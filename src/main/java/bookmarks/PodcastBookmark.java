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
public class PodcastBookmark extends AbstractBookmark {

    public PodcastBookmark(String author, String title, ArrayList<String> tags, ArrayList<String> releatedCourses, String description, String comment) {
        super.author = author;
        super.title = title;
        super.description = description;
        super.tags = tags;
        super.releatedCourses = releatedCourses;
        super.comment = comment;
    }

    public String tags() {
        String str = "";
        for (String s : this.tags) {
            str += s + ", ";
        }
        return str.substring(0, str.length() - 2);
    }

    public String releatedCourses() {
        String str = "";
        for (String s : this.releatedCourses) {
            str += s + ", ";
        }
        return str.substring(0, str.length() - 2);
    }

    @Override
    public String toString() {
        return "Kirjoittaja: " + author + "\n Otsikko: " + title + "\n Tyyppi: Kirja" + "\n Tagit: " + tags() + "\n Samankaltaisia kursseja: " + releatedCourses() + "\n Kuvaus: " + description +"\n Kommentti: " +comment;
    }

}
