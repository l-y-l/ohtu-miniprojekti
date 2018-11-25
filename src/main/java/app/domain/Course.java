
package app.domain;


public class Course {

    private String name; 

    public Course(String name) {
        this.name = name;
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
        if (o == null  || this.getClass() != o.getClass()){
            return false; 
        }
        Course c = (Course) o;
        return this.name.equals(c.getName());
    }
    
}
