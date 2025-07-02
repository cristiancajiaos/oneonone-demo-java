package com.example.oneononedemo.service;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.exception.ProfileNotFoundException;
import java.util.List;

public interface ProfileService {

  ProfileDto createProfile(ProfileDto profileDto);

  ProfileDto getProfileById(Long profileId) throws ProfileNotFoundException;

  List<ProfileDto> getAllProfiles();

  ProfileDto updateProfile(ProfileDto profileDto) throws ProfileNotFoundException;

  ProfileDto deleteProfile(Long id) throws ProfileNotFoundException;

}
