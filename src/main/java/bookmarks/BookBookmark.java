/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import app.domain.Course;
import app.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Class that is used to store bookmarks of books.
 *
 * @author jussiste
 */

@Entity
@Table(name="BookBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BookBookmark extends Bookmark {
    private String ISBN;
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }

    public BookBookmark(){
        tags = new ArrayList();
        relatedCourses = new ArrayList();
        prerequisiteCourses = new ArrayList();
    }

    public BookBookmark(String author, String title, String ISBN, List<Tag> tags, List<Course> prerequisiteCourses, List<Course> relatedCourses, String description, String comment) {
        super(author, title, "", tags, prerequisiteCourses, relatedCourses, description, comment);
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        String result = " Type: Book\n ISBN: " + this.ISBN + "\n";
        return result + super.toString();
    }

}
