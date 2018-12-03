package bookmarks;

import app.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Class that is used to store bookmarks of books.
 *
 * @author jussiste
 */

@Entity
@Table(name="BookBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BookBookmark extends Bookmark {
    private String author; 
    private String ISBN;


    public BookBookmark(){
        super(); 
    }

    public BookBookmark(String ISBN, String author, String title,  List<Tag> tags, String description) {
        super(title, tags, description);
        this.author = author; 
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
        
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }
   

    @Override
    public String toString() {
        String result = "ID: " + id + "\n Type: Book\n ISBN: " + this.ISBN + "\n Author: " + author;
        return result + "\n" + super.toString();
    }
    
    @Override
    public String shortPrint(){
        return super.shortPrint() + " Author: " + author; 
    }


}
