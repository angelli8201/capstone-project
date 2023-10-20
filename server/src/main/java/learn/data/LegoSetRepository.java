package learn.data;

import learn.models.LegoSet;

import java.util.List;

public interface LegoSetRepository {
    List<LegoSet> findAll();
    LegoSet findById(String setId);
    
}
