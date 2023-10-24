package learn.data;

import learn.models.Blog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BlogJdbcTemplateRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    BlogJdbcTemplateRepository repository;
    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindAll(){
        List<Blog> blogs = repository.findAll();
        assertNotNull(blogs);
    }
    @Test
    void findById() {
        Blog blog = repository.findById(1);
        assertEquals(1, blog.getBlogId());
        assertEquals("Animal Crossing", blog.getTitle());
    }

    @Test
    void add() {
        Blog blog = new Blog();
        blog.setTitle("Potato");
        blog.setDescription("Test Description");
        blog.setAuthor("Test author");
        blog.setDatePosted(LocalDate.of(2023,10,23));
        blog.setBlogId(4);

        Blog actual = repository.add(blog);

        assertEquals(blog, actual);
    }
    @Test
    void shouldUpdate() {
        Blog blog = new Blog();
        blog.setBlogId(1);
        blog.setDescription("testing");
        blog.setDatePosted(LocalDate.of(2023,10,10));
        blog.setAuthor("testing");
        blog.setTitle("Different title");
        assertTrue(repository.update(blog));

    }

    @Test
    void shouldDelete(){
        assertTrue(repository.delete(1));
    }


}
