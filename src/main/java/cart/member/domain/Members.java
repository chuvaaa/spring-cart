package cart.member.domain;

import cart.member.controller.dto.MemberResponse;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Members {

    private List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public List<MemberResponse> CreateMemberResponseList(){
        return members.stream()
                .map(MemberResponse::of)
                .collect(Collectors.toList());
    }
}
