package learn.domain;

import learn.data.LegoSetRepository;
import learn.data.ThemeRepository;
import learn.models.LegoSet;
import learn.models.Theme;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThemeService {
    private final ThemeRepository repository;

    public ThemeService(ThemeRepository repository) {
        this.repository = repository;
    }
    public List<Theme> findAll(){
        return repository.findAll();
    }

    public Theme findById(int themeId){
        return repository.findById(themeId);
    }
}
