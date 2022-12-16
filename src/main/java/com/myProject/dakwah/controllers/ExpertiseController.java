package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Expertise;
import com.myProject.dakwah.models.requests.ExpertiseRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.ExpertiseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping(UrlMappings.EXPERTISE_URL)
public class ExpertiseController {
    private ExpertiseService expertiseService;
    private ModelMapper modelMapper;

    public ExpertiseController(ExpertiseService expertiseService, ModelMapper modelMapper) {
        this.expertiseService = expertiseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createExpertise(@RequestBody ExpertiseRequest expertiseRequest) throws Exception{
        Expertise expertise = modelMapper.map(expertiseRequest, Expertise.class);
        Expertise result = expertiseService.createExpertise(expertise);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create expertise",result));
    }

    @GetMapping
    public ResponseEntity getExpertise() throws  Exception{
        List<Expertise> result = expertiseService.getAllExpertise();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get all expertise", result));
    }
}
