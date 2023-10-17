package learn.controllers;

import learn.domain.ThemeService;
import learn.models.NewsPost;
import learn.models.Theme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService service;


    public ThemeController(ThemeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Theme>> findAll(){
        List<Theme> themes = service.findAll();
        if(themes ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(themes);
    }

    @GetMapping("/{themeId}")
    public ResponseEntity<Theme> findById(@PathVariable int themeId){
        Theme theme = service.findById(themeId);
        if(theme ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(theme);
    }

}
