package com.myProject.dakwah.controllers;


import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Kajian;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.models.requests.KajianRequest;
import com.myProject.dakwah.models.requests.MosqueRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.KajianService;
import com.myProject.dakwah.services.MosqueService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.KAJIAN_URL)
public class KajianController {
    private KajianService kajianService;
    private ModelMapper modelMapper;

    public KajianController(KajianService kajianService, ModelMapper modelMapper) {
        this.kajianService = kajianService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createKajian(@RequestBody KajianRequest kajianRequest){
        Kajian kajian = modelMapper.map(kajianRequest, Kajian.class);
        Kajian result = kajianService.createKajian(kajian);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create kajian",result));
    }

    @GetMapping
    public ResponseEntity getKajian() throws Exception {

       List<Kajian> result = kajianService.getAllKajian();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create mosque", result));
    }
}
