package org.vagtsop.testproject.testprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.repository.NationRepository;

@Component
public class NationServiceImpl implements NationService {

    @Autowired
    private NationRepository nationRepository;

    @Override
    public Page<NationDto> getList(Pageable pageable) {
        return nationRepository.getList(pageable, new NationDto());
    }

//    @Override
//    public boolean delete(Long id) {
//        return documentRepository.delete(id);
//    }
}
