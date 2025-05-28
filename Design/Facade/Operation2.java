package Facade;

public class Operation2 {
    // Function of 2nd subsystem (can be simple or complex)
    public double operation2(Operation1 op1, int x) {
        return op1.operation1(x) + Math.sqrt(x);
    }
}
