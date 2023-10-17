package learn.data;

import learn.data.mappers.NewsPostMapper;
import learn.models.NewsPost;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NewsPostJdbcTemplateRepository implements NewsPostRepository{
    private final JdbcTemplate jdbcTemplate;

    public NewsPostJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<NewsPost> findAll() {
        final String sql = "select post_id, post_title, post_caption, date_posted from newsPost;";
        return jdbcTemplate.query(sql, new NewsPostMapper());
    }

    @Override
    public NewsPost findById(int postId) {
        final String sql = "select post_id, post_title, post_caption, date_posted " +
                "from newsPost " +
                "where post_id = ?;";
        return jdbcTemplate.query(sql,new NewsPostMapper(), postId).stream().findAny().orElse(null);
    }
}
