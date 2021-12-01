package com.kkulkkeog.member.domain.mapper;

import com.kkulkkeog.member.api.web.GetMemberResponse;
import com.kkulkkeog.member.api.web.PostMemberRequest;
import com.kkulkkeog.member.api.web.PostMemberResponse;
import com.kkulkkeog.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member toMember(PostMemberRequest postMemberRequest);

    PostMemberResponse toPostMemberResponse(Member member);

    GetMemberResponse toGetMemberResponse(Member member);
}
