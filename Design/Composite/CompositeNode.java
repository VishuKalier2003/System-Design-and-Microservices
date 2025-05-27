package Composite;

import Singleton.SingletonWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CompositeNode extends EntityNode {
    private final List<EntityNode> children;

    private final Active active;

    protected enum Active {
        HIGH, MEDIUM, LOW
    }

    public CompositeNode(int salary, int id, String name, String connection) {
        super(salary, id, name);
        this.children = new ArrayList<>();
        this.active = Active.valueOf(connection);
    }

    public List<EntityNode> directMembers() {
        return children;
    }

    public Active connectionType() {
        return this.active;
    }

    public void bfs(CompositeNode root) {
        ArrayDeque<EntityNode> queue = new ArrayDeque<>();
        queue.add(root);
        int nodeValue = 1;
        while (!queue.isEmpty()) {
            SingletonWriter.getInstance().dashLine();
            SingletonWriter.getInstance().printLine("Node : " + (nodeValue++));
            // Abstract method hence implemented differently for each class
            EntityNode node = queue.poll();
            if (node instanceof CompositeNode composite) {
                queue.addAll(composite.directMembers());

            }
        }
    }

    @Override
    protected void extract() {
    }

    @Override       // Override from base class here
    protected List<EntityNode> getChildren() {
        return this.children;
    }
}
