package Facade;

public class Operation3 {
    // Function of 3rd subsystem (can be simple or complex)
    public double operation3(Operation1 op1, Operation2 op2, int x) {
        return op1.operation1(x) * op2.operation2(op1, x);
    }
}
