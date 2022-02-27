package org.vagtsop.testproject.testprojectserver.response;

import org.vagtsop.testproject.testprojectserver.dto.NationDto;

public class NationResponse {
    private Long regionId;
    private String regionName;

    public NationResponse() {

    }

    public NationResponse(String field) {
        this.setRegionName(field);
    }

    public NationResponse(NationDto dto) {
        this.setRegionId(dto.getRegionId());
        this.setRegionName(dto.getRegionName());
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
}
