package learn.data.mappers;


import learn.models.Theme;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemeMapper implements RowMapper<Theme> {
    @Override
    public Theme mapRow(ResultSet resultSet, int i) throws SQLException {
        Theme theme = new Theme();
        theme.setThemeId(resultSet.getInt("theme_id"));
        theme.setThemeName(resultSet.getString("theme_name"));
        return theme;
    }
}
