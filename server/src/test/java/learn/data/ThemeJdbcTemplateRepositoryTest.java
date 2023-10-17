package learn.data;

import learn.models.LegoMiniFigure;
import learn.models.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ThemeJdbcTemplateRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ThemeJdbcTemplateRepository repository;

    @Test
    void shouldFindAll(){
        List<Theme> themes = repository.findAll();
        assertNotNull(themes);
    }

    @Test
    void shouldFindById1(){
        Theme theme = new Theme(1,"Space");
        Theme actual = repository.findById(1);
        assertEquals(theme,actual);
    }
}
