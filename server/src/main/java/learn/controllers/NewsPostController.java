package learn.controllers;

import learn.domain.NewsPostService;
import learn.models.NewsPost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsPostController {

    private final NewsPostService service;

    public NewsPostController(NewsPostService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<NewsPost>> findAll(){
        List<NewsPost> newsPosts = service.findAll();
        if(newsPosts ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(newsPosts);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<NewsPost> findById(@PathVariable int postId){
        NewsPost newsPost = service.findById(postId);
        if(newsPost ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(newsPost);
    }


}
