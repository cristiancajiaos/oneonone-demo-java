package com.example.oneononedemo.controller;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;
import com.example.oneononedemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

  @Autowired
  private ProfileService profileService;

  @PostMapping(value = "")
  public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDto) {
    ProfileDto createdProfile = profileService.createProfile(profileDto);
    return new ResponseEntity<>(createdProfile, HttpStatus.OK);
  }
}
