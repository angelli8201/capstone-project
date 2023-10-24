package learn.data;

import learn.data.mappers.BlogMapper;
import learn.models.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public class BlogJdbcTemplateRepository implements BlogRepository {
    private final JdbcTemplate jdbcTemplate;

    public BlogJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Blog> findAll() {
        final String sql = "select * from blog";
        return jdbcTemplate.query(sql,new BlogMapper());
    }

    @Override
    public Blog findById(int blogId) {
        final String sql = "select blog_id,blog_title,blog_description,date_posted,author " +
                "from blog " +
                "where blog_id = ?;";
        return jdbcTemplate.query(sql, new BlogMapper(), blogId).stream().findFirst().orElse(null);
    }

    @Override
    public Blog add(Blog blog) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("blog")
                .usingColumns("blog_title","blog_description","date_posted","author")
                .usingGeneratedKeyColumns("blog_id");
        HashMap<String,Object> args = new HashMap<>();
        args.put("blog_title", blog.getTitle());
        args.put("blog_description", blog.getDescription());
        args.put("date_posted", blog.getDatePosted());
        args.put("author", blog.getAuthor());
        args.put("blog_id", blog.getBlogId());

        int blogId = insert.executeAndReturnKey(args).intValue();
        blog.setBlogId(blogId);
        return blog;
    }

    @Override
    public boolean update(Blog blog) {
        final String sql = "update blog set " +
                "blog_title = ?, " +
                "blog_description = ?, " +
                "date_posted = ?, " +
                "author = ? " +
                "where blog_id = ?;";

        return jdbcTemplate.update(sql,
                blog.getTitle(),
                blog.getDescription(),
                blog.getDatePosted(),
                blog.getAuthor(),
                blog.getBlogId()) > 0;
    }

    @Override
    public boolean delete(int blogId) {
        final String sql = "delete from blog where blog_id = ?;";
        return jdbcTemplate.update(sql,blogId) > 0;
    }
}
