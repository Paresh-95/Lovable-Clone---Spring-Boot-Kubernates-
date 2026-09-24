package com.paresh.projects.lovable_clone.service.impl;

import com.paresh.projects.lovable_clone.dto.project.ProjectRequest;
import com.paresh.projects.lovable_clone.dto.project.ProjectResponse;
import com.paresh.projects.lovable_clone.dto.project.ProjectSummaryResponse;
import com.paresh.projects.lovable_clone.entity.Project;
import com.paresh.projects.lovable_clone.entity.ProjectMember;
import com.paresh.projects.lovable_clone.entity.ProjectMemberId;
import com.paresh.projects.lovable_clone.entity.User;
import com.paresh.projects.lovable_clone.enums.ProjectRole;
import com.paresh.projects.lovable_clone.error.ResourceNotFoundException;
import com.paresh.projects.lovable_clone.mapper.ProjectMapper;
import com.paresh.projects.lovable_clone.repository.ProjectMemberRepository;
import com.paresh.projects.lovable_clone.repository.ProjectRepository;
import com.paresh.projects.lovable_clone.repository.UserRepository;
import com.paresh.projects.lovable_clone.security.AuthUtil;
import com.paresh.projects.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
//      METHOD 1 :  => USING STREAM
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .collect(Collectors.toList());
//      METHOD 2: => USING MAPSTRUCT
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")  //SPEL (Spring Expression Language)  Using AOP (Aspect Oriented Programming)
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

        //find owner
//        User owner = userRepository.findById(userId).orElseThrow(
//                () -> new ResourceNotFoundException("User", userId.toString())
//        );

        User owner = userRepository.getReferenceById(userId);  //make proxy object no db call

        //create project
        Project project = Project
                .builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        //create owner member for the project
        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .projectRole(ProjectRole.OWNER)
                .id(projectMemberId)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        project.setName(request.name());
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void deleteProject(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    //internal functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(()-> new ResourceNotFoundException("Project",projectId.toString()));
    }


}
