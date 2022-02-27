package org.vagtsop.testproject.testprojectserver.dto;

public class NationDto {

    private Long countryId;

    private String countryName;

    private Long countryArea;

    private String countryCode2;

    private String language;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
