package learn.models;


import java.time.LocalDate;
import java.util.Objects;

public class NewsPost {
    int postId;
    String title;
    String caption;
    LocalDate datePosted;

    public NewsPost(){}
    public NewsPost(int postId, String title, String caption, LocalDate datePosted) {
        this.postId = postId;
        this.title = title;
        this.caption = caption;
        this.datePosted = datePosted;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsPost newsPost = (NewsPost) o;
        return postId == newsPost.postId && Objects.equals(title, newsPost.title) && Objects.equals(caption, newsPost.caption) && Objects.equals(datePosted, newsPost.datePosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, title, caption, datePosted);
    }
}
