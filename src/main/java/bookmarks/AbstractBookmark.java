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

 /*
@Entity
@Table(name="AbstractBookmark")
public abstract class AbstractBookmark {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "author")
    protected String author;

    @Column(name = "title")
    protected String title;

    @Column(name = "comment")
    protected String comment;

    @Column(name = "url")
    protected String url;

    @Column(name = "description")
    protected String description;

    @Transient
    protected ArrayList<String> tags;

    @Transient
    protected ArrayList<String> relatedCourses;

    @Transient
    protected ArrayList<String> prerequisiteCourses;

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

    public ArrayList<String> getRelatedCourses() {
        return relatedCourses;
    }

    public void setRelatedCourses(ArrayList<String> relatedCourses) {
        this.relatedCourses = relatedCourses;
    }

    public ArrayList<String> getPrerequisiteCourses() {
        return prerequisiteCourses;
    }

    public void setPrerequisiteCourses(ArrayList<String> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses;
    }


    public String relatedCoursesStr(){
        if (this.relatedCourses.isEmpty()){
            return "";
        }
        String str="";
        for(String s: this.relatedCourses){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }

    public String tagsStr(){
        if (this.tags.isEmpty()){
            return "";
        }
        String str="";
        for(String s: this.tags){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }

    public String preqCoursesStr() {
        if (this.prerequisiteCourses.isEmpty()){
            return "";
        }
        String str = "";
        for (String s : this.prerequisiteCourses) {
            str += s + ", ";
        }
        return str.substring(0, str.length() - 2);
    }

}
*/
