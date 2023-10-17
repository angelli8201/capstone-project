package learn.data.mappers;


import learn.models.LegoMiniFigure;
import learn.models.LegoSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegoSetMapper implements RowMapper<LegoSet> {
    @Override
    public LegoSet mapRow(ResultSet resultSet, int i) throws SQLException {
        LegoSet legoSet = new LegoSet();
        legoSet.setLegoSetId(resultSet.getInt("set_id"));
        legoSet.setSetName(resultSet.getString("set_name"));
        legoSet.setAmountOfPieces(resultSet.getInt("pieces"));
        legoSet.setPrice(resultSet.getDouble("price"));
        legoSet.setAges(resultSet.getString("ages"));
        legoSet.setImageUrl(resultSet.getString("image_url"));
        legoSet.setThemeId(resultSet.getInt("set_theme_id"));
        legoSet.setDescription(resultSet.getString("set_description"));
        legoSet.setRating(resultSet.getDouble("rating"));
        return legoSet;
    }
}
