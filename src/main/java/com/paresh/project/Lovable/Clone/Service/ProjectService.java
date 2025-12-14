package com.paresh.project.Lovable.Clone.Service;

import com.paresh.project.Lovable.Clone.Dto.Project.ProjectRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

public interface ProjectService {

    ProjectSummaryResponse getUserProjects(Long userId);

    ProjectResponse getUserProjectsById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);
}
