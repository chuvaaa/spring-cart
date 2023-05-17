package cart.member.application;

import cart.member.domain.Members;
import cart.member.controller.dto.MemberResponse;
import cart.member.infra.MemberDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author minsukim on 2023/05/17
 * @project jwp-cart
 * @description
 * MemberService
 */
@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public List<MemberResponse> getAllMembers() {
        Members members = memberDao.findAllMembers();

        return members.CreateMemberResponseList();
    }
}
