
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
        // System.out.println(">"+toPrint);
        prints.add(toPrint);
    }
    
    public ArrayList<String> getPrints() {
        return prints;
    }
    
    @Override
    public String nextLine() {
        if (i < lines.size()) {
            // System.out.println("<"+lines.get(i));
            return lines.get(i++);
        }
        // System.out.println("<");
        return "";
    }

    @Override
    public int nextInt() {
        return 0;
    }
    
}
