package org.vagtsop.testproject.testprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.service.NationService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/nation")
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping("/get-countries-list")
    public ResponseEntity<Page<NationDto>> getCountriesList(Pageable pageable) {
        Page<NationDto> retVal = nationService.getCountriesList(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @RequestMapping("/get-nation-list")
    public ResponseEntity<Page<NationDto>> getNationList(
            Pageable pageable,
            @RequestParam Optional<Long> regionId,
            @RequestParam Optional<Long> yearFrom,
            @RequestParam Optional<Long> yearTo
    ) {
        Page<NationDto> retVal = nationService.getNationList(pageable, regionId.orElse(null), yearFrom.orElse(null), yearTo.orElse(null));
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @GetMapping("/fetch-languages-spoken-by-country")
    public ResponseEntity<List<NationDto>> fetchLanguagesSpokenByCountry(
            @RequestParam long countryId) {
        List<NationDto> retVal = nationService.fetchLanguagesSpokenByCountry(countryId);
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @GetMapping("/fetch-regions")
    public ResponseEntity<List<NationDto>> fetchRegions() {
        List<NationDto> retVal = nationService.fetchRegions();
        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }
}
