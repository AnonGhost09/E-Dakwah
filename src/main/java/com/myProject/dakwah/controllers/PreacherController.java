package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Preacher;
import com.myProject.dakwah.models.requests.PreacherRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.PreacherService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.PREACHER_URL)
public class PreacherController {
    private PreacherService preacherService;
    private ModelMapper modelMapper;

    public PreacherController(PreacherService preacherService, ModelMapper modelMapper) {
        this.preacherService = preacherService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createPreacher(@RequestBody PreacherRequest preacherRequest){
        Preacher preacher = modelMapper.map(preacherRequest, Preacher.class);

        Preacher result = preacherService.createPreacher(preacher);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create preacher",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPreacherById(@PathVariable Integer id) throws Exception {

        Preacher result = preacherService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create preacher", result));
    }

    @GetMapping
    public ResponseEntity getPreacher() throws Exception {

        List<Preacher> result = preacherService.getAllPreacher();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create preacher", result));
    }
}
