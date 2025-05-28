package Facade;

// Provides a simplified interface for the client to work on, facade interacts with the subsystem classes
public class SimpleFacade { // The client never calls the subsystem classes grouped by facade

    // The main business code needs only 3 facade methods instead of multiple
    // subsystem methods
    public int operation1(int x) { // Class 1 function
        Operation1 op1 = new Operation1();
        return op1.operation1(x);
    }

    // The proxy pattern can be woven into the facade, rather than each subsystem
    public double operation2(int x) { // Class 2 function
        Operation1 op1 = new Operation1();
        Operation2 op2 = new Operation2();
        return op2.operation2(op1, x);
    }

    public double operation3(int x) { // Class 3 function
        Operation1 op1 = new Operation1();
        Operation2 op2 = new Operation2();
        Operation3 op3 = new Operation3();
        return op3.operation3(op1, op2, x);
    }
}
