package com.studytracker.profile.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "user_profile")
public class UserProfile {

    @Id
    String id = UUID.randomUUID().toString();  // Tự động sinh UUID cho MongoDB

    @Field("userId")
    String userId;

    String email;
    String name;
    LocalDate dob;
    String gender;
    Integer age;
    String occupation;
}
