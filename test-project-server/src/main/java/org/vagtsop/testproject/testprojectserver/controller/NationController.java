package org.vagtsop.testproject.testprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.response.NationResponse;
import org.vagtsop.testproject.testprojectserver.service.NationService;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/nation")
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping("/get-list")
    public ResponseEntity<Page<NationDto>> getList(Pageable pageable) {

        Page<NationDto> retVal = nationService.getList(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @GetMapping("/fetch-languages-spoken-by-country")
    public ResponseEntity<List<NationDto>> fetchLanguagesSpoken(
            @RequestParam long countryId) {

        List<NationDto> retVal = nationService.fetchLanguagesSpoken(countryId);

        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }

    @GetMapping("/fetch-regions")
    public ResponseEntity<Collection<NationResponse>> fetchRegions() {

        Collection<NationDto> nationDtos = nationService.fetchRegions();

        Collection<NationResponse> nationResponseList = new ArrayList<>();

        for (NationDto nationDto : nationDtos) {
            nationResponseList.add(new NationResponse(nationDto));
        }

        return ResponseEntity.status(HttpStatus.OK).body(nationResponseList);
    }

    @GetMapping("/get-nation-table-data")
    public ResponseEntity<Page<NationDto>> getList(
            @SortDefault(sort = "CONTINENT_NAME", direction = Sort.Direction.DESC)
            @PageableDefault(value = 10)
                    Pageable pageable,
            @RequestParam Optional<Long> regionId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> dateFrom,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> dateTo
            ) {

        Page<NationDto> retVal = nationService.getNationTableData(pageable, regionId.orElse(null), dateFrom.orElse(null), dateTo.orElse(null));

        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }
}
