package com.studytracker.identity.mapper;

import com.studytracker.identity.dto.request.ProfileCreationRequest;
import com.studytracker.identity.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
