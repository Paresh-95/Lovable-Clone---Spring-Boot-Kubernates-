package com.paresh.project.Lovable.Clone.Entity;

import com.paresh.project.Lovable.Clone.Enum.ProjectRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Getter
@Setter
public class ProjectMember {

    ProjectMemberId id;
    Project project;
    User user;

    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;

}
