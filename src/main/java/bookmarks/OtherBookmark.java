package bookmarks;

import app.domain.Tag;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class OtherBookmark extends Bookmark {
    private String url; 

    
    public OtherBookmark(){
        super(); 
    }

    public OtherBookmark(String title, String url, List<Tag> tags,  String description) {
        super(title, tags, description); 
        this.url = url;  
       
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    @Override
    public String toString() {
        return "ID: " + id + "\n Type: Other" + "\n Url: " + url
                + "\n" + super.toString(); 
    }

    @Override
    public String shortPrint() {
        return super.shortPrint() + " Url: " + url; 
    }

}
