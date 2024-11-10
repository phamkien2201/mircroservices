package com.studytracker.identity.repository.httpclient;

import com.studytracker.identity.configuration.AuthenticationRequest;
import com.studytracker.identity.dto.request.ApiResponse;
import com.studytracker.identity.dto.request.ProfileCreationRequest;
import com.studytracker.identity.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "profile-service", url = "${app.services.profile}",
        configuration = {AuthenticationRequest.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreationRequest request);
}

