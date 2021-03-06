package org.vagtsop.testproject.testprojectserver.dto;

public class NationDto {

    private Long countryId;

    private Long regionId;

    private String regionName;

    private String continentName;

    private Long countryYear;

    private Long countryGdp;

    private Long countryPopulation;

    private String countryName;

    private Long countryArea;

    private String countryCode2;

    private String language;

    private Long yearFrom;

    private Long yearTo;

    public NationDto() {

    }

    public NationDto(Long regionId, Long yearFrom, Long yearTo) {
        this.regionId = regionId;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

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

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Long yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Long getYearTo() {
        return yearTo;
    }

    public void setYearTo(Long yearTo) {
        this.yearTo = yearTo;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public Long getCountryYear() {
        return countryYear;
    }

    public void setCountryYear(Long countryYear) {
        this.countryYear = countryYear;
    }

    public Long getCountryGdp() {
        return countryGdp;
    }

    public void setCountryGdp(Long countryGdp) {
        this.countryGdp = countryGdp;
    }

    public Long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(Long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}
