/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * An abstract class that is used to create bookmarks, each kind of bookmark is created by a separate class that inherits this class. 
 * @author jussiste
 */

@MappedSuperclass
public abstract class AbstractBookmark {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    String author;

    String title;

    String comment;
    
    String url;

    String description;

    @Transient
    ArrayList<String> tags;

    @Transient
    ArrayList<String> releatedCourses;

    @Transient
    ArrayList<String> prerequisiteCourses;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getReleatedCourses() {
        return releatedCourses;
    }

    public void setReleatedCourses(ArrayList<String> releatedCourses) {
        this.releatedCourses = releatedCourses;
    }

    public ArrayList<String> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(ArrayList<String> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }
    
}
