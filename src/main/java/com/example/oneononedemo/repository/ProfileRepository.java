package com.example.oneononedemo.repository;

import com.example.oneononedemo.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
