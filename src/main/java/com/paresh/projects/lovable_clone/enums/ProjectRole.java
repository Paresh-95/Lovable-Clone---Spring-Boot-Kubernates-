package com.paresh.projects.lovable_clone.enums;

import com.paresh.projects.lovable_clone.entity.Project;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import static com.paresh.projects.lovable_clone.enums.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(Set.of(VIEW,EDIT,DELETE,VIEW_MEMBERS)),
    VIEWER(Set.of(VIEW,VIEW_MEMBERS)),
    OWNER(Set.of(VIEW,EDIT,DELETE,MANAGER_MEMBERS,VIEW_MEMBERS));




    private final Set<ProjectPermission> permissions;

}
