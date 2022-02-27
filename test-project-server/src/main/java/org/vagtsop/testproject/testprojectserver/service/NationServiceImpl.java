package org.vagtsop.testproject.testprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.repository.NationRepository;

import java.util.List;

@Component
public class NationServiceImpl implements NationService {

    @Autowired
    private NationRepository nationRepository;

    @Override
    public Page<NationDto> getList(Pageable pageable) {
        return nationRepository.getList(pageable);
    }

    @Override
    public List<NationDto> fetchLanguagesSpokenUrl(long countryId) {
        return nationRepository.fetchLanguagesSpokenUrl(countryId);
    }

    @Override
    public List<NationDto> fetchRegions() {
        return nationRepository.fetchRegions();
    }

}
