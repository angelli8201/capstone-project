package learn.controllers;


import learn.domain.LegoMiniFigureService;
import learn.models.LegoMiniFigure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/figures")
public class LegoMiniFigureController {

    private final LegoMiniFigureService service;


    public LegoMiniFigureController(LegoMiniFigureService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LegoMiniFigure>> findAll(){
        List<LegoMiniFigure> legoMiniFigures = service.findAll();
        if(legoMiniFigures ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(legoMiniFigures);
    }


    @GetMapping("/{figureId}")
    public ResponseEntity<LegoMiniFigure> findById(@PathVariable int figureId){
        LegoMiniFigure legoMiniFigure = service.findById(figureId);
        if(legoMiniFigure == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(legoMiniFigure);

    }
}
