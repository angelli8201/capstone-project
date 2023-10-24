package learn.controllers;

import learn.domain.BlogService;
import learn.domain.Result;
import learn.models.Blog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> findAll(){
        List<Blog> blogs = service.findAll();
        if(blogs ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> findById(@PathVariable int blogId){
        Blog blog = service.findById(blogId);
        if(blog ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(blog);
    }
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Blog blog) {
        Result<Blog> result = service.add(blog);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }
    @PutMapping("/{blogId}")
    public ResponseEntity<Object> update(@PathVariable int blogId, @RequestBody Blog blog) {
        if (blogId != blog.getBlogId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Blog> result = service.update(blog);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }
    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteById(@PathVariable int blogId) {
        if (service.deleteById(blogId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
