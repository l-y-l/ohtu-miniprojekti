/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;
import javax.persistence.*;

/**
 * Class that is used to store blogbookmarks
 * @author jussiste
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BlogBookmark extends AbstractBookmark{
    public BlogBookmark(){
        tags = new ArrayList<String>();
        releatedCourses = new ArrayList<String>();
        prerequisiteCourses = new ArrayList<String>();
    }
    
    public BlogBookmark(String author, String title, String url, ArrayList<String> tags, ArrayList<String> releatedCourses,  String description, String comment) {
        super.author=author;
        super.title = title;
        super.tags=tags;
        super.url = url;
        super.description=description;
        super.comment=comment;
        super.releatedCourses = releatedCourses;
    }
    @Override
    public String toString() {
        return "Tekijä: "+ author +"\n Otsikko: " + title+ "\n Url: "+url+ "\n Tyyppi: Blogpost"+"\n Tagit: " +tags()+"\n Samankaltaisia kursseja: "+ releatedCourses()+ "\n Kuvaus: "+description +"\n Kommentti: "+comment;
    }
}
