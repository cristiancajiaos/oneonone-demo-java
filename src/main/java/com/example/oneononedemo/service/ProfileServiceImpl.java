package com.example.oneononedemo.service;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;
import com.example.oneononedemo.mapper.ProfileMapper;
import com.example.oneononedemo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  public ProfileDto createProfile(ProfileDto profileDto) {
    Profile profile = ProfileMapper.mapToProfile(profileDto);
    Profile createdProfile = profileRepository.save(profile);
    return ProfileMapper.mapToProfileDto(createdProfile);
  }
}
