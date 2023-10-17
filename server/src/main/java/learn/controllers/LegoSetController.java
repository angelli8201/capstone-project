package learn.controllers;

import learn.domain.LegoSetService;
import learn.models.LegoSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/legos")
public class LegoSetController {

    private final LegoSetService service;
    public LegoSetController(LegoSetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LegoSet>> findAll(){
        List<LegoSet> legoSets = service.findAll();
        if(legoSets ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(legoSets);
    }

    @GetMapping("/{setId}")
    public ResponseEntity<LegoSet> findById(int setId){
        LegoSet legoSet = service.findById(setId);
        if(legoSet ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(legoSet);
    }

}
