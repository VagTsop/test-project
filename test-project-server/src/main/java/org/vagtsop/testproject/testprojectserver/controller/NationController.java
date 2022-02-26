package org.vagtsop.testproject.testprojectserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vagtsop.testproject.testprojectserver.dto.NationDto;
import org.vagtsop.testproject.testprojectserver.service.NationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/nation")
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping("/getList")
    public ResponseEntity<Page<NationDto>> getList(Pageable pageable) {

        Page<NationDto> retVal = nationService.getList(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(retVal);
    }
}
