package org.vagtsop.testproject.testprojectserver.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

import java.util.List;

public interface NationService {
    Page<NationDto> getCountriesList(Pageable pageable);

    List<NationDto> fetchLanguagesSpokenByCountry(long countryId);

    List<NationDto> fetchRegions();

    Page<NationDto> getNationList(Pageable pageable, Long regionId, Long yearFrom, Long yearTo
    );
}
