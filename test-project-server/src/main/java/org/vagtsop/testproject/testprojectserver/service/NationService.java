package org.vagtsop.testproject.testprojectserver.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

import java.util.Date;
import java.util.List;

public interface NationService {
    Page<NationDto> getList(Pageable pageable);

    List<NationDto> fetchLanguagesSpoken (long countryId);

    List<NationDto> fetchRegions();

    Page<NationDto> getNationTableData(Pageable pageable, Long regionId, Date dateFrom, Date dateTo
    );
}
