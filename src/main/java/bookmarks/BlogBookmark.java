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
 * Class that is used to store blogbookmarks
 *
 * @author jussiste
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BlogBookmark extends Bookmark {
    
    
    public BlogBookmark(){
        super(); 
    }

    public BlogBookmark(String author, String title, String url, List<Tag> tags,
            List<Course> prerequisiteCourses, List<Course> relatedCourses, String description, String comment) {

        super(author, title, url,  tags, prerequisiteCourses, relatedCourses, description, comment);
    }


    
    

    @Override
    public String toString() {
        return " Tyyppi: Blogpost\n" +  super.toString();
    }
}
