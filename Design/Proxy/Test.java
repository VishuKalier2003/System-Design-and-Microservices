package Proxy;

public class Test {

    public static void main(String[] args) {
        User user1 = new User(10000, "Vishu");
        User user2 = new User(4999, "Test-User");
        User user3 = new User(11008, "arpit");
        UserPayments proxy1 = new UserPayments(user1);
        proxy1.processPayment(1000);
        UserPayments proxy2 = new UserPayments(user2);
        proxy2.processPayment(1000);
        UserPayments proxy3 = new UserPayments(user3);
        proxy3.processPayment(1000);
    }
}
