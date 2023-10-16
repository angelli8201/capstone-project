package learn.data.mappers;

import learn.models.LegoMiniFigure;

import learn.models.LegoSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegoMiniFigureMapper implements RowMapper<LegoMiniFigure> {
    @Override
    public LegoMiniFigure mapRow(ResultSet resultSet, int i) throws SQLException {
        LegoMiniFigure legoMiniFigure = new LegoMiniFigure();
        legoMiniFigure.setFigureId(resultSet.getInt("figure_id"));
        legoMiniFigure.setFigureName(resultSet.getString("figure_name"));
        legoMiniFigure.setAmountOfPieces(resultSet.getInt("pieces"));
        legoMiniFigure.setImageUrl(resultSet.getString("image_url"));
        legoMiniFigure.setThemeId(resultSet.getInt("figure_theme_id"));
        return legoMiniFigure;
    }
}
