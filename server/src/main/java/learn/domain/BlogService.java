package learn.domain;

import learn.data.BlogRepository;
import learn.models.Blog;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository repository;


    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    public List<Blog> findAll() {
        return repository.findAll();
    }

    public Blog findById(int blogId) {
        return repository.findById(blogId);
    }

    public Result<Blog> add (Blog blog){
        Result<Blog> result = validate(blog);
        if (!result.isSuccess()) {
            return result;
        }

        if (blog.getBlogId() != 0) {
            result.addMessage("blogId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        blog = repository.add(blog);
        result.setPayload(blog);
        return result;
    }
    public Result<Blog> update(Blog blog) {
        Result<Blog> result = validate(blog);
        if (!result.isSuccess()) {
            return result;
        }

        if (blog.getBlogId() <= 0) {
            result.addMessage("blogId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(blog)) {
            String msg = String.format("blogId: %s, not found", blog.getBlogId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int blogId) {
        return repository.delete(blogId);
    }


    private Result<Blog> validate(Blog blog) {
        Result<Blog> result = new Result<>();
        if (blog == null) {
            result.addMessage("blog cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(blog.getTitle())) {
            result.addMessage("title is required", ResultType.INVALID);
        }

        if (Validations.isNullOrBlank(blog.getDescription())) {
            result.addMessage("blog is required", ResultType.INVALID);
        }



        if (blog.getAuthor() == null) {
            result.addMessage("author is required", ResultType.INVALID);
        }

        return result;
    }
}
