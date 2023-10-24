package learn.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Blog {
    int blogId;
    String title;
    String description;
    String author;
    Date datePosted;

    public Blog(int blogId, String title, String description, String author, Date datePosted) {
        this.blogId = blogId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.datePosted = datePosted;
    }
    public Blog(){}

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return blogId == blog.blogId && Objects.equals(title, blog.title) && Objects.equals(description, blog.description) && Objects.equals(author, blog.author) && Objects.equals(datePosted, blog.datePosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId, title, description, author, datePosted);
    }
}
