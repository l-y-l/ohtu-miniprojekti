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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class VideoBookmark extends AbstractBookmark{

    public VideoBookmark(){
        tags = new ArrayList<String>();
        releatedCourses = new ArrayList<String>();
        prerequisiteCourses = new ArrayList<String>();
    }

    public VideoBookmark(String title, String url, ArrayList<String> releatedCourses, ArrayList<String> tags, String description, String comment) {
        super.title = title;
        super.url = url;
        super.releatedCourses = releatedCourses;
        super.tags = tags;
        super.comment = comment;
        super.description=description;
    }

    @Override
    public String toString() {
        return "Otsikko: " + title+ "\n Url: "+url+ "\n Tyyppi: Video"+"\n Tagit: " +tags()+"\n Samankaltaisia kursseja: "+ releatedCourses() + "\n Kuvaus: "+description + "\n Kommentti: "+comment ;
    }
    
}
