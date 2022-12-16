package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.KajianSchedule;
import com.myProject.dakwah.models.requests.KajianScheduleRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.KajianScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.KAJIAN_SCHEDULE_URL)
public class KajianScheduleController {

    private KajianScheduleService kajianScheduleService;
    private ModelMapper modelMapper;

    public KajianScheduleController(KajianScheduleService kajianScheduleService, ModelMapper modelMapper) {
        this.kajianScheduleService = kajianScheduleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createKajianSchedule(@RequestBody KajianScheduleRequest kajianScheduleRequest){
        KajianSchedule kajianSchedule = modelMapper.map(kajianScheduleRequest, KajianSchedule.class);
        KajianSchedule result = kajianScheduleService.createKajianSchedule(kajianSchedule);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create kajianSchedule",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getKajianScheduleById(@PathVariable Integer id) throws Exception {

        KajianSchedule result = kajianScheduleService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create kajianSchedule", result));
    }

    @GetMapping
    public ResponseEntity getKajianSchedule() throws Exception {

        List<KajianSchedule> result = kajianScheduleService.getAllKajianSchedule();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create kajianSchedule", result));
    }
}
