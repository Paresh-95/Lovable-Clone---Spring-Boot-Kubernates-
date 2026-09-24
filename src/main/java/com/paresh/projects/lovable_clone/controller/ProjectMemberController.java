package com.paresh.projects.lovable_clone.controller;


import com.paresh.projects.lovable_clone.dto.project.member.InviteMemberRequest;
import com.paresh.projects.lovable_clone.dto.project.member.MemberResponse;
import com.paresh.projects.lovable_clone.dto.project.member.UpdateMemberRoleRequest;
import com.paresh.projects.lovable_clone.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId){
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping("/invite")
    public ResponseEntity<MemberResponse> inviteMember(@PathVariable Long projectId, @RequestBody @Valid InviteMemberRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId,request));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId, @PathVariable Long memberId, @RequestBody @Valid UpdateMemberRoleRequest request){
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId,request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long projectId,@PathVariable Long memberId){
        return ResponseEntity.ok(projectMemberService.removeProjectMember(projectId,memberId));
    }
}
