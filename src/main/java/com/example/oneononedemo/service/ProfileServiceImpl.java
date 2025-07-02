package com.example.oneononedemo.service;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;
import com.example.oneononedemo.exception.ProfileNotFoundException;
import com.example.oneononedemo.mapper.ProfileMapper;
import com.example.oneononedemo.repository.ProfileRepository;
import java.util.Optional;
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

  @Override
  public ProfileDto getProfileById(Long profileId) throws ProfileNotFoundException {
    Optional<Profile> profileToFind = profileRepository.findById(profileId);
    if (profileToFind.isEmpty()) {
      throw new ProfileNotFoundException("Profile with ID " + profileId + " not found");
    }
    Profile foundProfile = profileToFind.get();
    return ProfileMapper.mapToProfileDto(foundProfile);
  }
}
