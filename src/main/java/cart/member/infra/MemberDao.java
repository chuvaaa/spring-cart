package cart.member.infra;

import cart.member.domain.Member;
import cart.member.domain.Members;
import cart.member.infra.rowmapper.MemberRowMapper;
import cart.product.domain.Product;
import cart.product.domain.Products;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberDao extends NamedParameterJdbcDaoSupport {

    private static final String TABLE_NAME = "member";
    private static final String[] COLUMNS = {"email", "password"};
    private static final MemberRowMapper ROW_MAPPER = new MemberRowMapper();
    private final SimpleJdbcInsert simpleJdbcInsert;

    public MemberDao(DataSource dataSource) {
        setDataSource(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns("email")
                .usingColumns(COLUMNS);
    }
/*
    public void create(Product product) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);

        int key = simpleJdbcInsert.executeAndReturnKey(params).intValue();
        product.setId(key);
    }*/

    public Members findAllMembers() {
        final String query = String.format("SELECT * FROM %s", TABLE_NAME);
        List<Member> members = getNamedParameterJdbcTemplate()
                .query(query, ROW_MAPPER);

        return new Members(members);
    }

    /*public void update(Product product) {
        final String query = String.format("UPDATE %s " +
                "SET name = :name, image = :image, price = :price " +
                "WHERE id = :id", TABLE_NAME);
        SqlParameterSource params = new BeanPropertySqlParameterSource(product);
        getNamedParameterJdbcTemplate().update(query, params);

    }*/

    /*public void delete(Product product) {
        final String query = String.format("DELETE FROM %s WHERE id = :id", TABLE_NAME);
        SqlParameterSource params = new MapSqlParameterSource().addValue("id", product.getId());
        getNamedParameterJdbcTemplate().update(query, params);

    }*/

    /*public Product findById(int id) {
        final String query = String.format("SELECT * FROM %s WHERE id = :id", TABLE_NAME);
        SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);

        try {
            Product product = getNamedParameterJdbcTemplate()
                    .queryForObject(query, params, ROW_MAPPER);
            return product;
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("해당 id에 해당하는 상품이 없습니다.", 1);
        }


    }*/


}
