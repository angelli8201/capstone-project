package learn.data;

import learn.data.mappers.NewsPostMapper;
import learn.data.mappers.ThemeMapper;
import learn.models.Theme;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ThemeJdbcTemplateRepository implements ThemeRepository{
    private final JdbcTemplate jdbcTemplate;

    public ThemeJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Theme> findAll() {
        final String sql = "select theme_id, theme_name,theme_description,theme_url from theme;";
        return jdbcTemplate.query(sql, new ThemeMapper());
    }

    @Override
    public Theme findById(int themeId) {
        final String sql = "select theme_id, theme_name,theme_description,theme_url " +
                "from theme " +
                "where theme_id = ?;";
        return jdbcTemplate.query(sql,new ThemeMapper(), themeId).stream().findAny().orElse(null);
    }
}
