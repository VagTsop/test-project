package org.vagtsop.testproject.testprojectserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

import java.util.List;

public interface NationRepository {
    Page<NationDto> getList(Pageable pageable);

    List<NationDto> fetchLanguagesSpoken(long id);

    List<NationDto> fetchRegions();

    Page<NationDto> getNationTableData(Pageable pageable, NationDto dto);
}
