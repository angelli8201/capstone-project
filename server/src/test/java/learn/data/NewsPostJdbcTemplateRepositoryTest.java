package learn.data;

import learn.models.NewsPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NewsPostJdbcTemplateRepositoryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NewsPostJdbcTemplateRepository repository;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindAll(){
        List<NewsPost> newsPosts = repository.findAll();
        assertNotNull(newsPosts);
    }

    @Test
    void shouldFindById1(){
        NewsPost newsPost = new NewsPost(1,"New Space Sets Released!", "Explore the cosmos with our latest space-themed LEGO sets.", LocalDate.of(2023,10,15));
        NewsPost actual = repository.findById(1);
        assertEquals(newsPost,actual);
    }

}
