package learn.data;

import learn.models.LegoMiniFigure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LegoMiniFigureJdbcTemplateRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    LegoMiniFigureJdbcTemplateRepository repository;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindAll(){
        List<LegoMiniFigure> legoMiniFigures = repository.findAll();
        assertNotNull(legoMiniFigures);
    }

    @Test
    void shouldFindById1(){
        LegoMiniFigure legoMiniFigure = new LegoMiniFigure(100,"Astronaut", 10, "astronaut.jpg", 1);
        LegoMiniFigure actual = repository.findById(100);
        assertEquals(legoMiniFigure,actual);
    }


}
