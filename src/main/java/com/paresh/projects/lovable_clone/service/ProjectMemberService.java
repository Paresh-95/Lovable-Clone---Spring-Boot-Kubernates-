package com.paresh.projects.lovable_clone.service;

import com.paresh.projects.lovable_clone.dto.project.member.InviteMemberRequest;
import com.paresh.projects.lovable_clone.dto.project.member.MemberResponse;
import com.paresh.projects.lovable_clone.dto.project.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    MemberResponse removeProjectMember(Long projectId, Long memberId);
}
