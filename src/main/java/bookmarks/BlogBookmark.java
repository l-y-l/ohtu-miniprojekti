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
@Table(name="BlogBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BlogBookmark extends Bookmark {


    public BlogBookmark(){
        super();
    }

    public BlogBookmark(String author, String title, String url, List<Tag> tags,
             String description, String comment) {

        super(author, title, url,  tags,  description, comment);
    }





    @Override
    public String toString() {
        return "ID: " + id +  "\n Type: Blogpost\n" +  super.toString();
    }
}
