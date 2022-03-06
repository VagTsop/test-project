package org.vagtsop.testproject.testprojectserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

import java.util.List;

public interface NationRepository {
    Page<NationDto> getCountriesList(Pageable pageable);

    List<NationDto> fetchLanguagesSpokenByCountry(long id);

    List<NationDto> fetchRegions();

    Page<NationDto> getNationList(Pageable pageable, NationDto dto);
}
