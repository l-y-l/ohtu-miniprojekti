package bookmarks;

import javax.persistence.Entity;

@Entity
public class OtherBookmark extends Bookmark {

    
    public OtherBookmark(){}

    public OtherBookmark(String title, String url, String description) {
        setTitle(title); 
        setUrl(url); 
        setDescription(description); 
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n Type: Other\n" + " Title: " + title  + "\n Url: " + url
                + "\n Description: " + description; 
    }

}
