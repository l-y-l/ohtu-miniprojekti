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
public class BookBookmark extends AbstractBookmark{

    private String ISBN;

    public BookBookmark(String author, String title, String ISBN, ArrayList<String> tags, ArrayList<String> prerequisiteCourses, ArrayList<String> releatedCourses) {
        super.author = author;
        super.title = title;
        this.ISBN = ISBN;
        super.tags = tags;
        super.prerequisiteCourses = prerequisiteCourses;
        super.releatedCourses = releatedCourses;
    }
    public String tags(){
        String str="";
        for(String s: this.tags){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }
    public String preqCourses(){
        String str="";
        for(String s: this.prerequisiteCourses){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }
    public String releatedCourses(){
        String str="";
        for(String s: this.releatedCourses){
            str+=s + ", ";
        }
        return str.substring(0, str.length()-2);
    }
    @Override
    public String toString() {
        return "Kirjoittaja: "+ author +"\n Otsikko: " + title+ "\n Tyyppi: Kirja"+"\n ISBN: "+ISBN+"\n Tagit: " +tags()+"\n Esitietokurssit: "+preqCourses()+"\n Samankaltaisia kursseja: "+ releatedCourses();
    }
    
    
    
    
}
