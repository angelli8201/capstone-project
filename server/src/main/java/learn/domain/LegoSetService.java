package learn.domain;

import learn.data.LegoSetRepository;
import learn.models.LegoSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegoSetService {
    private final LegoSetRepository repository;

    public LegoSetService(LegoSetRepository repository) {
        this.repository = repository;
    }
    public List<LegoSet> findAll(){
        return repository.findAll();
    }

    public LegoSet findById(int setId){
        return repository.findById(setId);
    }


}
