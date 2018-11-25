package app.domain;

import bookmarks.Bookmark;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


//@Entity
public class Tag {
    
   // @ManyToMany(mappedBy ="tags")
    private List<Bookmark> bookmarks; 
    
    
    private String name; 

    public Tag(String name) {
        this.name = name;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    @Override
    public String toString(){
        return this.name; 
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()){
            return false; 
        }
        
        Tag t = (Tag) o;
        
        return this.name.equals(t.getName()); 
    }
    
}
