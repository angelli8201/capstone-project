package learn.domain;

import learn.data.LegoSetRepository;
import learn.data.NewsPostRepository;
import learn.models.LegoSet;
import learn.models.NewsPost;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsPostService {
    private final NewsPostRepository repository;

    public NewsPostService(NewsPostRepository repository) {
        this.repository = repository;
    }
    public List<NewsPost> findAll(){
        return repository.findAll();
    }

    public NewsPost findById(int postId){
        return repository.findById(postId);
    }
}
