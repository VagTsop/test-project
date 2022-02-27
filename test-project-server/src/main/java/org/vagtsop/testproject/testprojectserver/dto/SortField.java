package org.vagtsop.testproject.testprojectserver.dto;

public class SortField {
    public enum Field {
        CONTINENT_NAME("con.name"),
        REGION_NAME("r.name"),
        COUNTRY_NAME("c.name"),
        COUNTRY_YEAR("cs.year"),
        COUNTRY_POPULATION("cs.population"),
        COUNTRY_GDP("cs.gdp");

        private String value;

        Field(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}



