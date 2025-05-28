package Facade;

// Changes to the subsystem classes are hidden to client
public class Operation1 {
    // Function of 1st subsystem (can be simple or complex)
    public int operation1(int x) {
        // If I update this system, the updates cannot be seen by the client
        return x * x * x;
    }
}
