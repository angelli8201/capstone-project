package learn.domain;
import learn.data.LegoMiniFigureRepository;
import learn.models.LegoMiniFigure;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LegoMiniFigureService {
    private final LegoMiniFigureRepository repository;

    public LegoMiniFigureService(LegoMiniFigureRepository repository) {
        this.repository = repository;
    }
    public List<LegoMiniFigure> findAll(){
        return repository.findAll();
    }

    public LegoMiniFigure findById(int figureId){
        return repository.findById(figureId);
    }
}
