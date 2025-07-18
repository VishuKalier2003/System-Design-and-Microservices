
import java.util.Scanner;

public class TestChain {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            String s[] = new String[]{"s1", "s2"};
            Pipe.CHECK.operateAndTransfer(s).operateAndTransfer(s).operateAndTransfer(s);
        }
    }
}
