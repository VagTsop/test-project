package org.vagtsop.testproject.testprojectserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NationDto {

    @JsonProperty("countryId")
    private Long countryId;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("countryArea")
    private Long countryArea;
    @JsonProperty("countryCode2")
    private String countryCode2;


    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(Long countryArea) {
        this.countryArea = countryArea;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }
}
