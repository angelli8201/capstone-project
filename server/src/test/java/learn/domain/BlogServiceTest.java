package learn.domain;

import learn.data.BlogRepository;
import learn.models.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BlogServiceTest {
    @Autowired
    BlogService service;
    @MockBean
    BlogRepository repository;

    @Test
    void shouldFindAll() {
        List<Blog> expected = repository.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<Blog> actual = service.findAll();
        assertNotNull(actual);
    }
    @Test
    void shouldFindById() {
        Blog expected = new Blog(1,"Animal Crossing", "I cannot wait for the new Animal Crossing x Lego collaboration!", "legolover123",new Date(2023,10,10));
        when(repository.findById(1)).thenReturn(expected);
        Blog actual = service.findById(1);
        assertEquals(expected,actual);

    }
}
