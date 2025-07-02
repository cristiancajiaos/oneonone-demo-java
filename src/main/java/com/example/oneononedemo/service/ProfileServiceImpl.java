package com.example.oneononedemo.service;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;
import com.example.oneononedemo.exception.ProfileNotFoundException;
import com.example.oneononedemo.mapper.ProfileMapper;
import com.example.oneononedemo.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

  @Override
  public List<ProfileDto> getAllProfiles() {
    List<Profile> profiles = profileRepository.findAll();
    return profiles.stream().map((pr) -> ProfileMapper.mapToProfileDto(pr)).collect(Collectors.toList());
  }

  @Override
  public ProfileDto updateProfile(ProfileDto profileDto) throws ProfileNotFoundException {
    Long profileId = profileDto.getId();
    Optional<Profile> profileToFind = profileRepository.findById(profileId);
    if (profileToFind.isEmpty()) {
      throw new ProfileNotFoundException("Profile with ID " + profileId + " not found");
    }
    Profile profileFound = profileToFind.get();
    profileFound.setPhoneNumber(profileDto.getPhoneNumber());
    profileFound.setAddress(profileDto.getAddress());
    Profile profileSaved = profileRepository.save(profileFound);
    return ProfileMapper.mapToProfileDto(profileSaved);
  }

  @Override
  public ProfileDto deleteProfile(Long id) throws ProfileNotFoundException {
    Optional<Profile> profileFound = profileRepository.findById(id);
    if (profileFound.isEmpty()) {
      throw new ProfileNotFoundException("Profile with ID " + id + " not found");
    }
    profileRepository.deleteById(id);
    Profile profileDeleted = profileFound.get();
    return ProfileMapper.mapToProfileDto(profileDeleted);
  }
}
