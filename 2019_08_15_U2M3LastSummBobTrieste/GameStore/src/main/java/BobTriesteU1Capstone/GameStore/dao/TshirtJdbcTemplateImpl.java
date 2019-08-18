package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtJdbcTemplateImpl implements TshirtDao {

    private JdbcTemplate jdbcTemplate;

    private static final String ADD_TSHIRT_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String GET_TSHIRT_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    private static final String UPDATE_TSHIRT_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity=? where game_id = ?";

    private static final String DELETE_T_SHIRT_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_T_SHIRTS_BY_COLOR_SQL =
            "select * from t_shirt where color = ?";

    private static final String SELECT_T_SHIRTS_BY_SIZE =
            "select * from t_shirt where size = ?";

    @Autowired
    public TshirtJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Tshirt addTshirt(Tshirt tshirt) {
        jdbcTemplate.update(ADD_TSHIRT_SQL,

                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());

        int t_shirt_id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        tshirt.setTshirtId(t_shirt_id);

        return tshirt;
    }

    @Override
    public Tshirt getTshirt(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_TSHIRT_SQL, this::mapRowToTshirt, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console return null
            return null;
        }
    }
    @Override
    public List<Tshirt> getTshirtBySize(String size) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_SIZE, this::mapRowToTshirt, size);
    }

    @Override
    public List<Tshirt> getTShirtByColor(String color) {
        return jdbcTemplate.query(SELECT_T_SHIRTS_BY_COLOR_SQL, this::mapRowToTshirt, color);
    }

    @Override
    public List<Tshirt> getAllTshirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTshirt);
    }

    @Override
    public void updateTshirt (Tshirt tshirt) {
        jdbcTemplate.update(
                UPDATE_TSHIRT_SQL,
                tshirt.getSize(),
                tshirt.getColor(),
                tshirt.getDescription(),
                tshirt.getPrice(),
                tshirt.getQuantity());
    }

    @Override
    @Transactional
    public void deleteTshirt(int id) {
        try {
            jdbcTemplate.queryForObject(DELETE_T_SHIRT_SQL, this::mapRowToTshirt, id);
            jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
        } catch (EmptyResultDataAccessException e) {
            throw new NullPointerException("T-shirt id doesn't exist.");
        }
    }


    private Tshirt mapRowToTshirt(ResultSet rs, int rowNum) throws SQLException {
        Tshirt tshirt = new Tshirt();
        tshirt.setTshirtId(rs.getInt("t_shirt_id"));
        tshirt.setSize(rs.getString("size"));
        tshirt.setColor(rs.getString("color"));
        tshirt.setDescription(rs.getString("description"));
        tshirt.setPrice(rs.getBigDecimal("price"));
        tshirt.setQuantity(rs.getInt("quantity"));

        return tshirt;
    }
}
