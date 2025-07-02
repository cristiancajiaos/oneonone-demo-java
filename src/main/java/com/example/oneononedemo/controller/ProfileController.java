package com.example.oneononedemo.controller;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;
import com.example.oneononedemo.exception.ProfileNotFoundException;
import com.example.oneononedemo.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProfileDto> getProfileById(@PathVariable("id") Long profileId)
      throws ProfileNotFoundException{
    try {
      ProfileDto foundProfile = profileService.getProfileById(profileId);
      return new ResponseEntity<>(foundProfile, HttpStatus.OK);
    } catch (ProfileNotFoundException ex) {
      throw ex;
    }
  }

  @GetMapping(value = "")
  public ResponseEntity<List<ProfileDto>> getAllProfiles() {
    List<ProfileDto> profiles = profileService.getAllProfiles();
    return new ResponseEntity<>(profiles, HttpStatus.OK);
  }

  @PutMapping(value = "")
  public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profileDto)
      throws ProfileNotFoundException {
    try {
      ProfileDto profileDtoUpdated = profileService.updateProfile(profileDto);
      return new ResponseEntity<>(profileDtoUpdated, HttpStatus.OK);
    } catch (ProfileNotFoundException ex) {
      throw ex;
    }
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<ProfileDto> deleteProfile(@PathVariable("id") Long id)
      throws ProfileNotFoundException {
    try {
      ProfileDto profileFound = profileService.deleteProfile(id);
      return new ResponseEntity<>(profileFound, HttpStatus.OK);
    } catch (ProfileNotFoundException ex) {
      throw ex;
    }
  }
}
