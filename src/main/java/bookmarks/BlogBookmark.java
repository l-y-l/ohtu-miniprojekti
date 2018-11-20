/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmarks;

import java.util.ArrayList;

/**
 *
 * @author jussiste
 */
public class BlogBookmark extends AbstractBookmark{

    public BlogBookmark(String author, String title, String url, ArrayList<String> tags, ArrayList<String> releatedCourses) {
        super.author=author;
        super.title = title;
        super.tags=tags;
        super.url = url;
        super.releatedCourses = releatedCourses;
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
        return "Tekijä: "+ author +"\n Otsikko: " + title+ "\n Url: "+url+ "\n Tyyppi: Blogpost"+"\n Tagit: " +tags()+"\n Samankaltaisia kursseja: "+ releatedCourses();
    }
    

}
