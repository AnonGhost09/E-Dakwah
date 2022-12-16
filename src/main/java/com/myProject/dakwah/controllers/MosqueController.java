package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Mosque;
import com.myProject.dakwah.models.requests.MosqueRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.MosqueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.MOSQUE_URL)
public class MosqueController {

    private MosqueService mosqueService;
    private ModelMapper modelMapper;

    public MosqueController(MosqueService mosqueService, ModelMapper modelMapper) {
        this.mosqueService = mosqueService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createMosque(@RequestBody MosqueRequest mosqueRequest){
        Mosque mosque = modelMapper.map(mosqueRequest, Mosque.class);
        Mosque result = mosqueService.createMosque(mosque);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create mosque",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getMosqueById(@PathVariable Integer id) throws Exception {

        Mosque result = mosqueService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create mosque", result));
    }

    @GetMapping
    public ResponseEntity getMosque() throws Exception {

        List<Mosque> result = mosqueService.getAllMosque();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create mosque", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity getMosque(@PathVariable Integer id){

        Mosque result = mosqueService.deleteMosque(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success delete mosque", result));
    }
}
