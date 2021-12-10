package com.kkulkkeog.member.v1.domain.mapper;

import com.kkulkkeog.member.v1.api.web.MemberResponse;
import com.kkulkkeog.member.v1.api.web.PostMemberRequest;
import com.kkulkkeog.member.v1.api.web.PutMemberRequest;
import com.kkulkkeog.member.v1.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    Member toMember(PostMemberRequest request);

    Member toMember(Long no, PutMemberRequest request);

    MemberResponse toMemberResponse(Member member);
}
