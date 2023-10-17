package learn.domain;

import learn.data.LegoMiniFigureRepository;
import learn.models.LegoMiniFigure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LegoMiniFigureServiceTest {
    @Autowired
    LegoMiniFigureService service;
    @MockBean
    LegoMiniFigureRepository repository;

    @Test
    void shouldFindAll() {
        List<LegoMiniFigure> expected = repository.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<LegoMiniFigure> actual = service.findAll();
        assertNotNull(actual);

    }
    @Test
    void shouldFindById() {
        LegoMiniFigure expected = new LegoMiniFigure(1,"Testing",1,"Testing",1);
        when(repository.findById(1)).thenReturn(expected);
        LegoMiniFigure actual = service.findById(1);
        assertEquals(expected,actual);

    }
}
