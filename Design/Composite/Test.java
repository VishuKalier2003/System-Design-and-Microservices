package Composite;

public class Test { // Test class to perform operations
    public static void main(String[] args) {
        CompositeNode root = new CompositeNode(130000, 1549, "Vishu", "HIGH");
        CompositeNode node1 = new CompositeNode(200000, 14370, "Vansh", "LOW");
        Manager m1 = new Manager(120000, 13409, "Rithik", 14370);
        Developer d1 = new Developer(100000, 15287, "Rahul", 1549, "Male");
        // Root class has two children, 1 composite and 1 leaf (developer)
        root.addNode(node1);
        root.addNode(d1);
        // A composite class is given 1 leaf (manager)
        node1.addNode(m1);
        CompositeNode.bfs(root);
    }
}
