package com.studytracker.identity.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.studytracker.identity.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String username;
    String email;
    String name;
    String gender;
    Integer age;
    String occupation;

    @DobConstraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;

    List<String> roles;
}
