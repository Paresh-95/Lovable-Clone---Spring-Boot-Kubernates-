package com.paresh.project.Lovable.Clone.Controller;


import com.paresh.project.Lovable.Clone.Dto.Project.ProjectRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.ProjectSummaryResponse;
import com.paresh.project.Lovable.Clone.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<ProjectSummaryResponse> getMyProjects(){
        Long userId = 1L;  //update later with real spring security
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

   @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
       Long userId = 1L;
       return ResponseEntity.ok(projectService.getUserProjectsById(id,userId));
   }

   @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
       Long userId = 1L;
       return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request,userId));
   }

   @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectRequest request){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.updateProject(id,request,userId));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
       Long userId = 1L;
       projectService.softDelete(id,userId);
       return ResponseEntity.noContent().build();
   }



}
