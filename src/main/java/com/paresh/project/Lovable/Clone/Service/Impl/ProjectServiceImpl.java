package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Project.ProjectRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectSummaryResponse;
import com.paresh.project.Lovable.Clone.Entity.Project;
import com.paresh.project.Lovable.Clone.Entity.User;
import com.paresh.project.Lovable.Clone.Repository.ProjectRepository;
import com.paresh.project.Lovable.Clone.Repository.UserRepository;
import com.paresh.project.Lovable.Clone.Service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .build();

        project =  projectRepository.save(project);

        return new ProjectResponse(project.getId(),project.getName(),project.getOwner())


    }


    @Override
    public ProjectSummaryResponse getUserProjects(Long userId) {
        return null;
    }

    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {
        return null;
    }


    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
