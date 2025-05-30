package Strategy;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StrategyContext contextObj;
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine(); // We can use builder pattern here
            String type = sc.next();
            contextObj = new StrategyContext(type, input.split(" "));
            contextObj.payments(1000, input.split(" "));
            contextObj = new StrategyContext("RUPAY", input.split(" "));
            contextObj.payments(1000, input.split(" "));
            contextObj = new StrategyContext("Bitcoin", input.split(" "));
            contextObj.payments(100, input.split(" "));
            sc.close();
        }
    }
}
