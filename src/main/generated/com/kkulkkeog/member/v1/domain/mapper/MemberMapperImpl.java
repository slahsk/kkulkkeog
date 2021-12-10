package com.kkulkkeog.member.v1.domain.mapper;

import com.kkulkkeog.member.v1.api.web.MemberResponse;
import com.kkulkkeog.member.v1.api.web.MemberResponse.MemberResponseBuilder;
import com.kkulkkeog.member.v1.api.web.PostMemberRequest;
import com.kkulkkeog.member.v1.api.web.PutMemberRequest;
import com.kkulkkeog.member.v1.domain.Member;
import com.kkulkkeog.member.v1.domain.Member.MemberBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-11T00:19:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toMember(PostMemberRequest request) {
        if ( request == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.email( request.getEmail() );
        member.password( request.getPassword() );
        member.name( request.getName() );

        return member.build();
    }

    @Override
    public Member toMember(Long no, PutMemberRequest request) {
        if ( no == null && request == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        if ( request != null ) {
            member.email( request.getEmail() );
            member.password( request.getPassword() );
            member.name( request.getName() );
        }

        return member.build();
    }

    @Override
    public MemberResponse toMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseBuilder memberResponse = MemberResponse.builder();

        memberResponse.email( member.getEmail() );
        memberResponse.name( member.getName() );

        return memberResponse.build();
    }
}
