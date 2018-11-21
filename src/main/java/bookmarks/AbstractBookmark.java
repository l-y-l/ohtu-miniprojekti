/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;

/**
 * An abstract class that is used to create bookmarks, each kind of bookmark is created by a separate class that inherits this class. 
 * @author jussiste
 */
public abstract class AbstractBookmark {
    String author;
    String title;
    String comment;
    String url;
    String description;
    ArrayList<String> tags;
    ArrayList<String> releatedCourses;
    ArrayList<String> prerequisiteCourses;
}
