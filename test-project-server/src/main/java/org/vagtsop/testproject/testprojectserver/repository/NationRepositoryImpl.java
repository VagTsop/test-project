package org.vagtsop.testproject.testprojectserver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.dto.SortField;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("NationRepository")
public class NationRepositoryImpl implements NationRepository {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Page<NationDto> getCountriesList(Pageable pageable) {

        String sqlQuery = "SELECT c.country_id as countryId,\n" +
                "c.name as countryName,\n" +
                "c.area AS countryArea,\n" +
                "c.country_code2 AS countryCode2 FROM countries as c ORDER BY c.name asc limit :offset,:size\n";

        MapSqlParameterSource in = new MapSqlParameterSource();

        in.addValue("offset", pageable.getOffset());
        in.addValue("size", pageable.getPageSize());

        String rowCountSql = "SELECT count(*) AS row_count FROM countries as c";

        int total = this.namedParameterJdbcTemplate.queryForObject(rowCountSql, in, Integer.class);

        List<NationDto> res = namedParameterJdbcTemplate.query(sqlQuery, in, new BeanPropertyRowMapper<>(NationDto.class));

        return new PageImpl<>(res, pageable, total);
    }

    @Override
    public List<NationDto> fetchLanguagesSpokenByCountry(long id) {
        MapSqlParameterSource in = new MapSqlParameterSource();

        String sqlQuery = "Select l.language_id, l.language\n" +
                "From country_languages as cl\n" +
                "Inner join languages l On l.language_id = cl.language_id\n" +
                "where cl.country_id = :id \n";

        in.addValue("id", id);
        return namedParameterJdbcTemplate.query(sqlQuery, in, new BeanPropertyRowMapper<>(NationDto.class));
    }

    @Override
    public List<NationDto> fetchRegions() {

        String sqlQuery = "select r.region_id as regionId, r.name as regionName \n" +
                "from regions as r\n" +
                "order by r.name asc";
        return namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(NationDto.class));
    }

    public Page<NationDto> getNationList(Pageable pageable, NationDto dto) {

        String sqlFromClause = "From countries as c\n" +
                "join country_stats as cs on cs.country_id = c.country_id\n" +
                "join regions as r on r.region_id = c.region_id\n" +
                "join continents as con on con.continent_id = r.continent_id \n";


        String sqlWhereClause = "WHERE c.country_id is not null\n";

        MapSqlParameterSource in = new MapSqlParameterSource();

        if (dto.getRegionId() != null) {
            sqlWhereClause += "AND r.region_id = :regionId\n";
            in.addValue("regionId", dto.getRegionId());
        }

        if (dto.getYearFrom() != null) {
            sqlWhereClause += "AND cs.year >= :yearFrom ";
            in.addValue("yearFrom", dto.getYearFrom());
        }

        if (dto.getYearTo() != null) {
            sqlWhereClause += "AND cs.year <= :yearTo ";
            in.addValue("yearTo", dto.getYearTo());
        }

        List<String> validSortColumns = new ArrayList<String>();
        validSortColumns.add("CONTINENT_NAME");
        validSortColumns.add("REGION_NAME");
        validSortColumns.add("COUNTRY_NAME");
        validSortColumns.add("COUNTRY_YEAR");
        validSortColumns.add("COUNTRY_POPULATION");
        validSortColumns.add("COUNTRY_GDP");

        List<Sort.Order> sortOrders = pageable.getSort().stream().collect(Collectors.toList());
        Sort.Order order = sortOrders.get(0);

        String sqlPaginationClause = "ORDER BY ";

        if (validSortColumns.contains(order.getProperty())) {
            sqlPaginationClause += SortField.Field.valueOf(order.getProperty()).getValue();
            if (order.getDirection().isAscending()) {
                sqlPaginationClause += " ASC ";
            } else {
                sqlPaginationClause += " DESC ";
            }
        }

        sqlPaginationClause += "limit :offset,:size";

        in.addValue("offset", pageable.getOffset());
        in.addValue("size", pageable.getPageSize());

        String rowCountSql = "SELECT count(*) AS row_count " +
                sqlFromClause + sqlWhereClause;
        ;

        int total = this.namedParameterJdbcTemplate.queryForObject(
                rowCountSql, in, Integer.class);

        String sqlQuery = "Select con.name as continentName, r.name as regionName,\n" +
                "c.name as countryName, cs.year as countryYear, cs.gdp as countryGdp,\n" +
                "cs.population as countryPopulation \n" +
                sqlFromClause + sqlWhereClause + sqlPaginationClause;

        List<NationDto> res = namedParameterJdbcTemplate.query(sqlQuery, in, new BeanPropertyRowMapper<>(NationDto.class));

        return new PageImpl<>(res, pageable, total);
    }
}


