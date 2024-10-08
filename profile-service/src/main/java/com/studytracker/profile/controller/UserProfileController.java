package com.studytracker.profile.controller;

import com.studytracker.profile.dto.request.ProfileCreationRequest;
import com.studytracker.profile.dto.response.UserProfileResponse;
import com.studytracker.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/users")
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request){
        return userProfileService.createProfile(request);
    }

    @GetMapping("/users/{profileId}")
    UserProfileResponse getProfile(@PathVariable String profileId){
        return userProfileService.getProfile(profileId);
    }
}