package org.vagtsop.testproject.testprojectserver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;

public interface NationRepository {
    Page<NationDto> getList(Pageable pageable);
}
