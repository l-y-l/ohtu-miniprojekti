package app.domain;

import bookmarks.Bookmark;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "relatedCourses")
    private Set<Bookmark> relatedToBookmars;

    @ManyToMany(mappedBy = "prerequisiteCourses")
    private Set<Bookmark> prerequisiteForBookmarks;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Bookmark> getPrerequisiteForBookmarks() {
        return prerequisiteForBookmarks;
    }

    public Set<Bookmark> getRelatedToBookmars() {
        return relatedToBookmars;
    }

    public void setRelatedToBookmars(Set<Bookmark> relatedToBookmars) {
        this.relatedToBookmars = relatedToBookmars;
    }

    public void setPrerequisiteForBookmarks(Set<Bookmark> prerequisiteForBookmarks) {
        this.prerequisiteForBookmarks = prerequisiteForBookmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Course c = (Course) o;
        return this.name.equals(c.getName());
    }

}
