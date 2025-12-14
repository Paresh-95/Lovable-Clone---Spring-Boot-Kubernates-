package com.paresh.project.Lovable.Clone.Controller;


import com.paresh.project.Lovable.Clone.Dto.Project.Member.InviteMemberRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.MemberResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.UpdateMemberRoleRequest;
import com.paresh.project.Lovable.Clone.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project/{projectId}/members")
public class ProjectMemberController {


    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> projectProjectMembers(@PathVariable Long projectId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,userId));

    }

    @PostMapping("/invite")
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId,@RequestBody InviteMemberRequest request){
      Long userId = 1L;
      return ResponseEntity.status(HttpStatus.CREATED).body(
              projectMemberService.inviteMember(projectId,request,userId)
      );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> changeMemberRole(@PathVariable Long projectId,@PathVariable Long memberId, @RequestBody UpdateMemberRoleRequest request){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteProjectMember(@PathVariable Long projectId,@PathVariable Long memberId){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId,userId));
    }




}
