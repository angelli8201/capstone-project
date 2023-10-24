package learn.data;

import learn.models.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();
    Blog findById(int blogId);
    Blog add(Blog blog);
    boolean update(Blog blog);
    boolean delete(int blogId);

}
