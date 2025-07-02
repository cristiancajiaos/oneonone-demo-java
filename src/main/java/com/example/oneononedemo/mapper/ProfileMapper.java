package com.example.oneononedemo.mapper;

import com.example.oneononedemo.dto.ProfileDto;
import com.example.oneononedemo.entity.Profile;

public class ProfileMapper {
  public static ProfileDto mapToProfileDto(Profile profile) {
    return new ProfileDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(),  profile.getUser(), profile.getCreated(), profile.getUpdated());
  }

  public static Profile mapToProfile(ProfileDto profileDto) {
    return new Profile(profileDto.getId(), profileDto.getPhoneNumber(), profileDto.getAddress(),
        profileDto.getUser(), profileDto.getCreated(), profileDto.getUpdated());
  }

}
