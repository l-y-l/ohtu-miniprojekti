/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import app.domain.Course;
import app.domain.Tag;
import app.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * An abstract class that is used to create bookmarks, each kind of bookmark is
 * created by a separate class that inherits this class.
 *
 * @author jussiste
 */
@Entity
public abstract class Bookmark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String author;
    String title;
    // not really common to all subclasses; should perhaps be moved? Ebooks may have
    // url, though...
    String url;
    String comment;
    String description;

    // toistaiseksi eager, sillä jos Session ei auki ja esim kutsutaan bookmarkin 
    // toString => virhe
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookmark_tags",
            joinColumns = {
                @JoinColumn(name = "bookmark_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id")})
    @Fetch(value = FetchMode.SUBSELECT)

    List<Tag> tags;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookmark_related_courses",
            joinColumns = {
                @JoinColumn(name = "bookmark_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "course_id")})
    @Fetch(value = FetchMode.SUBSELECT)

    List<Course> relatedCourses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookmark_prerequisite_courses",
            joinColumns = {
                @JoinColumn(name = "bookmark_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "course_id")})
    @Fetch(value = FetchMode.SUBSELECT)
    List<Course> prerequisiteCourses;

    // Hibernate requires a constructor with no parameters
    public Bookmark() {
        tags = new ArrayList();
        prerequisiteCourses = new ArrayList();
        relatedCourses = new ArrayList();
    }

    public Bookmark(String author, String title, String url, List<Tag> tags, List<Course> prerequisiteCourses, List<Course> relatedCourses, String description, String comment) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.prerequisiteCourses = prerequisiteCourses;
        this.relatedCourses = relatedCourses;
        this.description = description;
        this.comment = comment;

    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Course> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public List<Course> getRelatedCourses() {
        return relatedCourses;
    }

    public void setRelatedCourses(List<Course> relatedCourses) {
        this.relatedCourses = relatedCourses;
    }

    public void setPrerequisiteCourses(List<Course> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }

    public String relatedCoursesStr() {
        return Utilities.formStringSeparatedByCommas(relatedCourses);
    }

    public String tagsStr() {
        return Utilities.formStringSeparatedByCommas(tags);
    }

    public String preqCoursesStr() {
        
        return Utilities.formStringSeparatedByCommas(prerequisiteCourses);

    }

    @Override
    public String toString() {
        String result
                = " Tekijä: " + author + "\n"
                + " Otsikko: " + title + "\n";

        if (!(url == null || url.isEmpty())) {
            result += " Url: " + url + "\n";
        }

        
        result += " Tagit: " + tagsStr() + "\n"
                + " Esitietokurssit: " + preqCoursesStr() + "\n"
                + " Samankaltaisia kursseja: " + relatedCoursesStr() + "\n"
                + " Kuvaus: " + description + "\n"
                + " Kommentti: " + comment;
        return result;
    }

}
