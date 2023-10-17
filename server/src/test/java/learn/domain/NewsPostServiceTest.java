package learn.domain;

import learn.data.NewsPostRepository;
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
public class NewsPostServiceTest {
    @Autowired
    NewsPostService service;
    @MockBean
    NewsPostRepository repository;

    @Test
    void shouldFindAll() {
        List<NewsPost> expected = repository.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<NewsPost> actual = service.findAll();
        assertNotNull(actual);

    }
    @Test
    void shouldFindById() {
        NewsPost expected = new NewsPost(1,"Testing","Testing", LocalDate.now());
        when(repository.findById(1)).thenReturn(expected);
        NewsPost actual = service.findById(1);
        assertEquals(expected,actual);

    }
}
