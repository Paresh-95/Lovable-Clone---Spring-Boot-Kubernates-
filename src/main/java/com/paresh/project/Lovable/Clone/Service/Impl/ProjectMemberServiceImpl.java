package com.paresh.project.Lovable.Clone.Service.Impl;

import com.paresh.project.Lovable.Clone.Dto.Project.Member.InviteMemberRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.MemberResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.UpdateMemberRoleRequest;
import com.paresh.project.Lovable.Clone.Service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {
        return null;
    }

    @Override
    public Void deleteProjectMember(Long projectId, Long userId) {
        return null;
    }
}
