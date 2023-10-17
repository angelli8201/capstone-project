package learn.domain;

import learn.data.ThemeRepository;
import learn.domain.ThemeService;
import learn.models.Theme;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ThemeServiceTest {
    @Autowired
    ThemeService service;

    @MockBean
    ThemeRepository repository;


    @Test
    void shouldFindAll() {
        List<Theme> expected = repository.findAll();
        when(repository.findAll()).thenReturn(expected);
        List<Theme> actual = service.findAll();
        assertNotNull(actual);

    }
    @Test
    void shouldFindById() {
        Theme expected = new Theme(1,"Testing");
        when(repository.findById(1)).thenReturn(expected);
        Theme actual = service.findById(1);
        assertEquals(expected,actual);

    }

}