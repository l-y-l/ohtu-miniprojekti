package bookmarks;

import app.domain.Tag;
import java.util.List;
import javax.persistence.*;

/**
 * Class that is used to store blogbookmarks
 *
 * @author jussiste
 */
@Entity
@Table(name = "BlogBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BlogBookmark extends Bookmark {

    private String url;

    public BlogBookmark() {
        super();
    }

    public BlogBookmark(String title, String url, List<Tag> tags,
            String description) {

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
        return "ID: " + id + "\n Type: Blogpost\n Url: " + url + "\n" + super.toString();
    }
    
    @Override
    public String shortPrint(){
        return super.shortPrint() + " Url: " + url; 
    }
}
