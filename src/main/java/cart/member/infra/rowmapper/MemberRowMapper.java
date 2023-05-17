package cart.member.infra.rowmapper;

import cart.member.domain.Member;
import cart.product.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberRowMapper implements RowMapper<Member> {

    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Member.builder()
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .createdDt(rs.getTimestamp("created_dt").toLocalDateTime())
                .build();
    }

}
