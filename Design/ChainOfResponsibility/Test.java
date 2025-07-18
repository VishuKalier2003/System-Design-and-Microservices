
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            Pipe.TRANSFER.operateAndTransfer(new String[]{sc.nextLine(), sc.nextLine()});
        }
    }
}
