package bookmarks;

import app.domain.Course;
import app.domain.Tag;
import java.util.List;
import javax.persistence.*;

/**
 * Class that is used to store bookmarks of podcasts.
 *
 * @author jussiste
 */
@Entity
@Table(name="PodcastBookmark")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PodcastBookmark extends Bookmark {

    public PodcastBookmark() {
        super();
    }

    public PodcastBookmark(String author, String title, String url,List<Tag> tags,
            List<Course> prerequisiteCourses, List<Course> relatedCourses, String description, String comment) {

        super(author, title, url, tags, prerequisiteCourses, relatedCourses, description, comment);
    }





    @Override
    public String toString() {
        return "ID: " + id + "\n Type: Podcast\n" + super.toString();
    }

}
