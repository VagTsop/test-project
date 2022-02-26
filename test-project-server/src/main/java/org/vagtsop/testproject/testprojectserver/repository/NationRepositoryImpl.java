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

    public Page<NationDto> getList(Pageable pageable, NationDto dto) {

        String sqlFromClause = "FROM countries AS c\n";

        String sqlWhereClause = "WHERE c.country_id is not null\n";

        MapSqlParameterSource in = new MapSqlParameterSource();


        List<String> validSortColumns = new ArrayList<String>();
        validSortColumns.add("ID");
        validSortColumns.add("NAME");


        List<Sort.Order> sortOrders = pageable.getSort().stream().collect(Collectors.toList());
        Sort.Order order = sortOrders.get(0);

        String sqlPaginationClause = "ORDER BY ";

        if (validSortColumns.contains(order.getProperty())) {
            sqlPaginationClause += SortField.Field.valueOf(order.getProperty()).getValue();
            if (order.getDirection().isAscending()) {
                sqlPaginationClause += " ASC ";
            }
            else {
                sqlPaginationClause += " DESC ";
            }
        }

        sqlPaginationClause += "limit :offset,:size";

        in.addValue("offset", pageable.getOffset());
        in.addValue("size", pageable.getPageSize());

        String rowCountSql = "SELECT count(*) AS row_count " +
                sqlFromClause + sqlWhereClause;

        int total = this.namedParameterJdbcTemplate.queryForObject(rowCountSql, in, Integer.class);

        String sqlQuery = "SELECT c.country_id as countryId,\n" +
                "c.name as countryName,\n" +
                "c.area AS countryArea,\n" +
                "c.country_code2 AS countryCode2\n" +


                sqlFromClause + sqlWhereClause + sqlPaginationClause;


        List<NationDto> res = namedParameterJdbcTemplate.query(sqlQuery, in, new BeanPropertyRowMapper<>(NationDto.class));

        return new PageImpl<>(res, pageable, total);


    }

//    @Override
//    public Page<NationDto> getList(Pageable pageable, NationDto dto) {
//
//        String sqlFromClause = "from document as doc\n" +
//                "left join document_user as dt on doc.id = dt.document_id \n";
//
//        String sqlWhereClause = "WHERE doc.id is not null\n";
//
//        MapSqlParameterSource in = new MapSqlParameterSource();
//
//        if (dto.getDateFrom() != null) {
//            sqlWhereClause += "AND cast(le.creation_datetime AS date) >= :dateFrom ";
//            in.addValue("dateFrom", dto.getDateFrom());
//        }
//
//        if (dto.getDateTo() != null) {
//            sqlWhereClause += "AND cast(le.creation_datetime AS date) <= :dateTo ";
//            in.addValue("dateTo", dto.getDateTo());
//        }
//
//        if (dto.getType() != null  && !dto.getType().trim().isEmpty()) {
//            sqlWhereClause += "AND doc.type = :type\n";
//            in.addValue("type", dto.getType());
//        }
//        if (dto.getUploadDate() != null) {
//            sqlWhereClause += "AND doc.upload_date = :uploadDate\n";
//            in.addValue("uploadDate", dto.getUploadDate());
//        }
//        if (dto.getUsername() != null && !dto.getUsername().trim().isEmpty()) {
//            sqlWhereClause += "AND dt.username = :username\n";
//            in.addValue("username", dto.getUsername());
//        }
//
//        List<String> validSortColumns = new ArrayList<String>();
//        validSortColumns.add("ID");
//        validSortColumns.add("NAME");
//        validSortColumns.add("TYPE");
//        validSortColumns.add("UPLOAD_DATE");
//        validSortColumns.add("USERNAME");
//
//        List<Sort.Order> sortOrders = pageable.getSort().stream().collect(Collectors.toList());
//        Sort.Order order = sortOrders.get(0);
//
//        String sqlPaginationClause = "ORDER BY ";
//
//        if (validSortColumns.contains(order.getProperty())) {
//            sqlPaginationClause += SortField.Field.valueOf(order.getProperty()).getValue();
//            if (order.getDirection().isAscending()) {
//                sqlPaginationClause += " ASC ";
//            }
//            else {
//                sqlPaginationClause += " DESC ";
//            }
//        }
//
//        sqlPaginationClause += "limit :offset,:size";
//
//        in.addValue("offset", pageable.getOffset());
//        in.addValue("size", pageable.getPageSize());
//
//        String rowCountSql = "SELECT count(*) AS row_count " +
//                sqlFromClause + sqlWhereClause;;
//
//        int total = this.namedParameterJdbcTemplate.queryForObject(
//                rowCountSql, in, Integer.class);
//
//        String sqlQuery = "Select doc.id as documentId, doc.name as name,\n" +
//                "doc.type as type,\n" +
//                "doc.upload_date AS uploadDate,\n" +
//                "dt.username AS username\n" +   sqlFromClause + sqlWhereClause + sqlPaginationClause;
//
//        List<NationDto> res = namedParameterJdbcTemplate.query(sqlQuery, in, new BeanPropertyRowMapper<>(NationDto.class));
//
//        return new PageImpl<>(res, pageable, total);
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        MapSqlParameterSource in = new MapSqlParameterSource("id", id);
//        String sqlQuery = "DELETE FROM document WHERE id = :id";
//        return namedParameterJdbcTemplate.update(sqlQuery, in) > 0;
//    }

}