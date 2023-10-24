package learn.data.mappers;

import learn.models.Blog;
import learn.models.LegoSet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogMapper implements RowMapper<Blog> {
    @Override
    public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
        Blog blog = new Blog();
        blog.setBlogId(resultSet.getInt("blog_id"));
        blog.setTitle(resultSet.getString("blog_title"));
        blog.setDescription(resultSet.getString("blog_description"));
        blog.setAuthor(resultSet.getString("author"));
        blog.setDatePosted(resultSet.getDate("date_posted"));
        return blog;
    }
}

