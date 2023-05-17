package cart.member.controller.dto;

import cart.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final String email;
    private final String password;

    public MemberResponse(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getEmail(), member.getPassword());
    }
}
