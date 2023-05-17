package cart.member.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

/**
* @author 1101466 on 2023/05/17
* @description Member domain
**/
@Getter
@Builder
public class Member {

    private String email;
    private String password;
    private LocalDateTime createdDt;

    public Member(String email, String password, LocalDateTime createdDt) {
        this.email = email;
        this.password = password;
        this.createdDt = createdDt;
    }

    public static Member of(String email, String password) {
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }

}
