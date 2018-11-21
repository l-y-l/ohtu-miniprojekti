
package app.io;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private final Scanner scanner = new Scanner(System.in);
    
    @Override
    public void println(String toPrint) {
        System.out.println(toPrint);
    }
    
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
    
}
