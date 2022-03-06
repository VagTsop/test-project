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
    public Page<NationDto> getCountriesList(Pageable pageable) {
        return nationRepository.getCountriesList(pageable);
    }

    @Override
    public List<NationDto> fetchLanguagesSpokenByCountry(long countryId) {
        return nationRepository.fetchLanguagesSpokenByCountry(countryId);
    }

    @Override
    public List<NationDto> fetchRegions() {
        return nationRepository.fetchRegions();
    }

    @Override
    public Page<NationDto> getNationList(Pageable pageable, Long regionId,
                                                  Long yearFrom,
                                                  Long yearTo) {
        return nationRepository.getNationList(pageable, new NationDto(regionId, yearFrom, yearTo));
    }
}
