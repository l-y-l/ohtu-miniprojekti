
package app.io;

import java.util.ArrayList;
import java.util.List;


public class StubIO implements IO {
    
    private List<String> lines;
    private int i;
    private ArrayList<String> prints;
    
    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }
    
    @Override
    public void println(String toPrint) {
       prints.add(toPrint);
    }
    
    public ArrayList<String> getPrints() {
        return prints;
    }
    
    @Override
    public String nextLine() {
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "";
    }

    
}
