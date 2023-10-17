package learn.data;

import learn.models.LegoSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LegoSetJdbcTemplateRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    LegoSetJdbcTemplateRepository repository;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindAll(){
        List<LegoSet> legoSets = repository.findAll();
        assertNotNull(legoSets);
    }

    @Test
    void shouldFindById1(){
        LegoSet legoSet = new LegoSet(000,"Space Shuttle", 500, 59.99, "8-12", "space_shuttle.jpg", 1, "Explore the galaxy with this awesome space shuttle!", 4.0);
        LegoSet actual = repository.findById(000);
        assertEquals(legoSet,actual);
    }

}
