package org.vagtsop.testproject.testprojectserver.dto;

public class SortField {
    public enum Field {
        ID("c.id"),
        NAME("c.name");


        private String value;

        Field(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
