/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * Class that is used to store bookmarks of videos.
 * @author jussiste
 */

@Entity
@Table(name="VideoBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class VideoBookmark extends AbstractBookmark{
    // Hibernate requires a constructor with no parameterss
    public VideoBookmark() {
        tags = new ArrayList<String>();
        relatedCourses = new ArrayList<String>();
        prerequisiteCourses = new ArrayList<String>();
    }

    public VideoBookmark(String title, String url, ArrayList<String> relatedCourses, ArrayList<String> tags, String description, String comment) {
        super.title = title;
        super.url = url;
        super.relatedCourses = relatedCourses;
        super.tags = tags;
        super.comment = comment;
        super.description=description;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
               + " Title: " + title + "\n"
               + " Url: " + url + "\n"
               + " Type: Video" + "\n"
               + " Tags: " + tagsStr() + "\n"
               + " Related courses: " + relatedCoursesStr() + "\n"
               + " Description: " + description + "\n"
               + " Comment: " + comment;
    }
    
}
