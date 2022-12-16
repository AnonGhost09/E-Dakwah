package com.myProject.dakwah.controllers;

import com.myProject.dakwah.constansts.UrlMappings;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Profile;
import com.myProject.dakwah.models.User;
import com.myProject.dakwah.models.requests.ProfileRequest;
import com.myProject.dakwah.models.responses.SuccessResponse;
import com.myProject.dakwah.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.PROFILE_URL)
public class ProfileController {

    private ProfileService profileService;
    private ModelMapper modelMapper;

    public ProfileController(ProfileService profileService, ModelMapper modelMapper) {
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createProfile(@RequestBody ProfileRequest profileRequest) throws Exception {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Profile profile = modelMapper.map(profileRequest, Profile.class);

        Profile result = profileService.createProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create profile",result));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProfileById(@PathVariable Integer id) throws Exception{

        Profile result = profileService.findById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create profile", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateProfile(@PathVariable Integer id, @RequestBody ProfileRequest profileRequest) throws Exception{
        Profile profile = modelMapper.map(profileRequest,Profile.class);
        profile.setProfileId(id);
        Profile result = profileService.updateProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create profile", result));
    }

    @GetMapping
    public ResponseEntity getProfile() throws Exception{

        List<Profile> result = profileService.getAllProfile();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success create profile", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity getProfile(@PathVariable Integer id) throws Exception{

        Profile result = profileService.deleteProfile(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new SuccessResponse<>( "Success delete profile", result));
    }
}
