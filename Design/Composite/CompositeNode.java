package Composite;

import Singleton.SingletonWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// This is the composite class used to connect leaf and composite elements in Composition pattern
public class CompositeNode extends EntityNode {
    private final List<EntityNode> children; // To store the children (just like a tree)

    private final Active active; // Extra parameter to mark the connection

    protected enum Active {
        HIGH, MEDIUM, LOW
    }

    public CompositeNode(int salary, int id, String name, String connection) {
        super(salary, id, name); // Inherited from abstract parent class
        this.children = new ArrayList<>();
        this.active = Active.valueOf(connection);
    }

    public List<EntityNode> directMembers() {
        return children;
    }

    public Active connectionType() {
        return this.active;
    }

    public void addNode(EntityNode node) {
        this.children.add(node);
    }

    public static void bfs(CompositeNode root) { // Doing bfs from any node (here root)
        ArrayDeque<EntityNode> queue = new ArrayDeque<>(); // ArrayDeque of type entity node
        queue.add(root);
        int nodeValue = 1;
        while (!queue.isEmpty()) {
            SingletonWriter.getInstance().dashLine();
            SingletonWriter.getInstance().printLine("Node : " + (nodeValue++));
            // Abstract method hence implemented differently for each class
            EntityNode node = queue.poll();
            node.extract(); // This method is automatically implemented differently since abstract methods
                            // are always defined for each subclass
            // If the node is an instance of composite class
            if (node instanceof CompositeNode composite)
                // Since composite class will store all the connections, we are only interested
                // in Composite class, this (directMemebers()) and list of children is only
                // present in composite class
                queue.addAll(composite.directMembers());
        }
    }

    @Override
    protected void extract() {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("ID : " + getID());
        SingletonWriter.getInstance().printLine("Name : " + getName());
        SingletonWriter.getInstance().printLine("Salary : " + getSalary());
        SingletonWriter.getInstance().printLine("Children : " + getChildren().size());
        SingletonWriter.getInstance().printLine("Active : " + connectionType());
        for (EntityNode node : this.children) {
            SingletonWriter.getInstance().printLine("Child Node Id : " + node.getID());
        }
    }

    @Override // Override from base class here
    protected List<EntityNode> getChildren() {
        return this.children;
    }
}
