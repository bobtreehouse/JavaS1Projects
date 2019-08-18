package BobTriesteU1Capstone.GameStore.dao;


import BobTriesteU1Capstone.GameStore.model.Game;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GameJdbcTemplateImpl implements GameDao{

    private JdbcTemplate jdbcTemplate;

    private static final String ADD_GAME_SQL =
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

    private static final String GET_GAME_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static  final String GET_GAMES_BY_STUDIO_SQL =
            "select * from game where studio = ?";


    private static final String SELECT_GAME_BY_ESRB_RATING_SQL =
            "select * from game where esrb_rating = ?";

    private static final String SELECT_GAME_BY_Title_SQL =
            "select * from game where studio = ?";

    private static final String UPDATE_GAME_SQL =
            "update game set title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity=? where game_id = ?";

    private static final String DELETE_GAME =
            "delete from game where game_id = ?";

    @Autowired
    public GameJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(ADD_GAME_SQL,

                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());

        int game_id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        game.setGameId(game_id);

        return game;
    }

    @Override
    public Game getGame(int id) {
        try {
            return jdbcTemplate.queryForObject(GET_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this console return null
            return null;
        }
    }


    @Override
    public List<Game> getAllGames() {

        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL, this::mapRowToGame);
    }

    @Override
    public Game updateGame (Game game) {
        jdbcTemplate.update(
                UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrb_rating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getGameId());
        return jdbcTemplate.queryForObject(GET_GAME_SQL, this::mapRowToGame, game.getGameId());
    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(GET_GAMES_BY_STUDIO_SQL, this::mapRowToGame, studio);
    }

    @Override
    public List<Game> getGameByTitle(String string) {
        return jdbcTemplate.query(SELECT_GAME_BY_Title_SQL, this::mapRowToGame, string);
    }

    @Override
    public List<Game> getGameByESRBRating(String string) {
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, string);
    }

    @Override
    public void deleteGame(int gameid) {
        jdbcTemplate.update(DELETE_GAME, gameid);
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("game_id"));
        game.setTitle(rs.getString("title"));
        game.setEsrb_rating(rs.getString("esrb_rating"));
        game.setDescription(rs.getString("description"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setStudio(rs.getString("studio"));
        game.setQuantity(rs.getInt("quantity"));

        return game;
    }
}
