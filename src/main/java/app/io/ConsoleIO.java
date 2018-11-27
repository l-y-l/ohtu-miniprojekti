
package app.io;

import java.util.Scanner;

public class ConsoleIO implements IO {
    private final Scanner scanner;
    
    public ConsoleIO(){
        this.scanner = new Scanner(System.in);
    }
    public ConsoleIO(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public void println(String toPrint) {
        System.out.println(toPrint);
    }
    
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
    @Override
    public int nextInt(){
        return scanner.nextInt();
    }
}
