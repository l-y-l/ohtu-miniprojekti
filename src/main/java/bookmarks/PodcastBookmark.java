/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * Class that is used to store bookmarks of podcasts.
 * @author jussiste
 */

@Entity
@Table(name="PodcastBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PodcastBookmark extends AbstractBookmark {
    // Hibernate requires a constructor with no parameters
    public PodcastBookmark() {
        tags = new ArrayList<String>();
        relatedCourses = new ArrayList<String>();
        prerequisiteCourses = new ArrayList<String>();
    }

    public PodcastBookmark(String author, String title, ArrayList<String> tags, ArrayList<String> relatedCourses, String description, String comment) {
        super.author = author;
        super.title = title;
        super.description = description;
        super.tags = tags;
        super.relatedCourses = relatedCourses;
        super.comment = comment;
    }


    @Override
    public String toString() {
        return   "Author: " + author + "\n"
               + "Title: " + title + "\n"
               + "Type: Podcast" + "\n"
               + "Tags: " + tagsStr() + "\n"
               + "Related courses: " + relatedCoursesStr() + "\n"
               + "Description: " + description + "\n"
               + "Comment: " + comment;
    }

}
