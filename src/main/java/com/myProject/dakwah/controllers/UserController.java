package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Profile;
import com.myProject.dakwah.models.User;
import com.myProject.dakwah.models.requests.UserRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.USER_URL)
public class UserController {

    private UserService userService;

    private ModelMapper modelMapper;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) throws Exception {
        User user = modelMapper.map(userRequest, User.class);
        User result = userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create user",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) throws Exception {

        User result = userService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create user", result));
    }

    @GetMapping
    public ResponseEntity getUser() throws Exception {

        List<User> result = userService.getAllUser();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success get user", result));
    }
}
