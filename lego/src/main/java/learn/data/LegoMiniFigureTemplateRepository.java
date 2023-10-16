package learn.data;

import learn.data.mappers.LegoMiniFigureMapper;

import learn.data.mappers.LegoSetMapper;
import learn.models.LegoMiniFigure;
import learn.models.LegoSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LegoMiniFigureTemplateRepository implements LegoMiniFigureRepository{
    private final JdbcTemplate jdbcTemplate;

    public LegoMiniFigureTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LegoMiniFigure> findAll() {
        final String sql = "select figure_id, figure_name, pieces,image_url,figure_theme_id from legoMiniFigure;";
        return jdbcTemplate.query(sql, new LegoMiniFigureMapper());
    }

    @Override
    public LegoMiniFigure findById(int figureId) {
        final String sql = "select figure_id, figure_name, pieces,image_url,figure_theme_id" +
                "from legoMiniFigure " +
                "where figure_id = ?;";
        return jdbcTemplate.query(sql,new LegoMiniFigureMapper(), figureId).stream().findAny().orElse(null);
    }
}
