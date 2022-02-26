package org.vagtsop.testproject.testprojectserver.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

import java.util.List;

public interface NationService {
    Page<NationDto> getList(Pageable pageable);

    List<NationDto> fetchLanguagesSpokenUrl (long countryId);
}
