package learn.data;

import learn.models.NewsPost;

import java.util.List;

public interface NewsPostRepository {
    List<NewsPost> findAll();
    NewsPost findById(int postId);
}
