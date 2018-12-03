package bookmarks;

import app.domain.Tag;
import app.utilities.Utilities;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * An abstract class that is used to create bookmarks, each kind of bookmark is
 * created by a separate class that inherits this class.
 *
 * @author jussiste
 */
@Entity
public abstract class Bookmark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String author;
    String title;
    // not really common to all subclasses; should perhaps be moved? Ebooks may have
    // url, though...
    String url;
    String comment;
    String description;

    // toistaiseksi eager, sillä jos Session ei auki ja esim kutsutaan bookmarkin
    // toString => virhe
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookmark_tags",
            joinColumns = {
                @JoinColumn(name = "bookmark_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id")})
    @Fetch(value = FetchMode.SUBSELECT)

    List<Tag> tags;
    // Hibernate requires a constructor with no parameters
    public Bookmark() {
        tags = new ArrayList();
    }

    public Bookmark(String author, String title, String url, List<Tag> tags, String description, String comment) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.tags = tags;
        this.description = description;
        this.comment = comment;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String tagsStr() {
        return Utilities.formStringSeparatedByCommas(tags);
    }
    @Override
    public String toString() {
        String result
                = " Author: " + author + "\n"
                + " Title: " + title + "\n";

        if (!(url == null || url.isEmpty())) {
            result += " Url: " + url + "\n";
        }


        result += " Tags: " + tagsStr() + "\n"
                + " Description: " + description + "\n"
                + " Comment: " + comment;
        return result;
    }
    public String shortPrint(){
        return "ID: "+this.id+" Title: "+this.title+" Author: "+this.author;
    }
}
