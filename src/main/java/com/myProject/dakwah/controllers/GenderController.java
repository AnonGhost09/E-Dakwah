package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.requests.GenderRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.GenderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.GENDER_URL)
public class GenderController {
    private GenderService genderService;
    private ModelMapper modelMapper;

    public GenderController(GenderService genderService, ModelMapper modelMapper) {
        this.genderService = genderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createGender(@RequestBody GenderRequest genderRequest){
        Gender gender = modelMapper.map(genderRequest, Gender.class);
        Gender result = genderService.createGender(gender);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create gender",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getGenderById(@PathVariable Integer id) throws Exception {

        Gender result = genderService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create gender", result));
    }

    @GetMapping
    public ResponseEntity getGender() throws Exception {

        List<Gender> result = genderService.getAllGender();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create gender", result));
    }
}
