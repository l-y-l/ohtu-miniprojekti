/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;

/**
 * Class that is used to store bookmarks of videos.
 * @author jussiste
 */
public class VideoBookmark extends AbstractBookmark{

    public VideoBookmark(String title, String url, ArrayList<String> releatedCourses, ArrayList<String> tags, String description, String comment) {
        super.title = title;
        super.url = url;
        super.releatedCourses = releatedCourses;
        super.tags = tags;
        super.comment = comment;
        super.description=description;
    }
    public String releatedCourses(){
        String str="";
        for(String s: this.releatedCourses){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }
    public String tags(){
        String str="";
        for(String s: this.tags){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }
    @Override
    public String toString() {
        return "Otsikko: " + title+ "\n Url: "+url+ "\n Tyyppi: Video"+"\n Tagit: " +tags()+"\n Samankaltaisia kursseja: "+ releatedCourses() + "\n Kuvaus: "+description + "\n Kommentti: "+comment ;
    }
    
}
