package learn.data.mappers;


import learn.models.LegoMiniFigure;
import learn.models.NewsPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsPostMapper implements RowMapper<NewsPost> {
    @Override
    public NewsPost mapRow(ResultSet resultSet, int i) throws SQLException {
        NewsPost newsPost = new NewsPost();
        newsPost.setPostId(resultSet.getInt("post_id"));
        newsPost.setTitle(resultSet.getString("post_title"));
        newsPost.setCaption(resultSet.getString("post_caption"));
        newsPost.setDatePosted(resultSet.getDate("date_posted").toLocalDate());
        return newsPost;
    }
}
