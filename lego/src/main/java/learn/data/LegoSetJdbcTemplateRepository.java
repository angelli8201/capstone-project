package learn.data;

import learn.data.mappers.LegoSetMapper;
import learn.models.LegoSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LegoSetJdbcTemplateRepository implements LegoSetRepository{
    private final JdbcTemplate jdbcTemplate;

    public LegoSetJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LegoSet> findAll() {
        final String sql = "select set_id, set_name, pieces, price,ages,image_url,set_theme_id,set_description,rating from legoSet;";
        return jdbcTemplate.query(sql, new LegoSetMapper());
    }

    @Override
    public LegoSet findById(int setId) {
        final String sql = "select set_id, set_name, pieces, price,ages,image_url,set_theme_id,set_description,rating" +
                "from legoSet " +
                "where set_id = ?;";
        return jdbcTemplate.query(sql,new LegoSetMapper(), setId).stream().findAny().orElse(null);
    }
}
