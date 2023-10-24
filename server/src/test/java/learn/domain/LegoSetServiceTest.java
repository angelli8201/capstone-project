package learn.domain;

import learn.data.LegoSetRepository;
import learn.models.LegoSet;
import learn.models.NewsPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LegoSetServiceTest {
    @Autowired
    LegoSetService service;
    @MockBean
    LegoSetRepository repository;

    @Test
    void shouldFindAll() {
        List<LegoSet> expected = repository.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<LegoSet> actual = service.findAll();
        assertNotNull(actual);

    }
    @Test
    void shouldFindById() {
        LegoSet expected = new LegoSet("000","Testing",1,1.0,"Testing","Testing",1,"Testing",1.0 );
        when(repository.findById("000")).thenReturn(expected);
        LegoSet actual = service.findById("000");
        assertEquals(expected,actual);

    }
}
