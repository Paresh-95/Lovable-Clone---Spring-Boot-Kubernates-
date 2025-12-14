package com.paresh.project.Lovable.Clone.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
@Setter
public class ChatSession {
//    ProjectMemberId id;

    Project project;
    User user;

    String title;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;




}
