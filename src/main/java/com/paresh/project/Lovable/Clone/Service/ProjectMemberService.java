package com.paresh.project.Lovable.Clone.Service;


import com.paresh.project.Lovable.Clone.Dto.Project.Member.InviteMemberRequest;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.MemberResponse;
import com.paresh.project.Lovable.Clone.Dto.Project.Member.UpdateMemberRoleRequest;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    Void deleteProjectMember(Long projectId, Long userId);
}
