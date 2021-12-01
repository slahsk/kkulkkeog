package com.kkulkkeog.member.domain.mapper;

import com.kkulkkeog.member.api.web.GetMemberResponse;
import com.kkulkkeog.member.api.web.GetMemberResponse.Address.AddressBuilder;
import com.kkulkkeog.member.api.web.GetMemberResponse.GetMemberResponseBuilder;
import com.kkulkkeog.member.api.web.PostMemberRequest;
import com.kkulkkeog.member.api.web.PostMemberResponse;
import com.kkulkkeog.member.api.web.PostMemberResponse.PostMemberResponseBuilder;
import com.kkulkkeog.member.domain.Address;
import com.kkulkkeog.member.domain.Member;
import com.kkulkkeog.member.domain.Member.MemberBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-01T23:09:27+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toMember(PostMemberRequest postMemberRequest) {
        if ( postMemberRequest == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.email( postMemberRequest.getEmail() );
        member.id( postMemberRequest.getId() );
        member.password( postMemberRequest.getPassword() );
        member.name( postMemberRequest.getName() );

        return member.build();
    }

    @Override
    public PostMemberResponse toPostMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        PostMemberResponseBuilder postMemberResponse = PostMemberResponse.builder();

        postMemberResponse.no( member.getNo() );
        postMemberResponse.email( member.getEmail() );
        postMemberResponse.id( member.getId() );
        postMemberResponse.name( member.getName() );

        return postMemberResponse.build();
    }

    @Override
    public GetMemberResponse toGetMemberResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        GetMemberResponseBuilder getMemberResponse = GetMemberResponse.builder();

        getMemberResponse.no( member.getNo() );
        getMemberResponse.email( member.getEmail() );
        getMemberResponse.id( member.getId() );
        getMemberResponse.name( member.getName() );
        getMemberResponse.addresses( addressListToAddressList( member.getAddresses() ) );

        return getMemberResponse.build();
    }

    protected com.kkulkkeog.member.api.web.GetMemberResponse.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressBuilder address1 = com.kkulkkeog.member.api.web.GetMemberResponse.Address.builder();

        address1.title( address.getTitle() );
        address1.address( address.getAddress() );
        address1.message( address.getMessage() );
        address1.phoneNumber( address.getPhoneNumber() );

        return address1.build();
    }

    protected List<com.kkulkkeog.member.api.web.GetMemberResponse.Address> addressListToAddressList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<com.kkulkkeog.member.api.web.GetMemberResponse.Address> list1 = new ArrayList<com.kkulkkeog.member.api.web.GetMemberResponse.Address>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddress( address ) );
        }

        return list1;
    }
}
