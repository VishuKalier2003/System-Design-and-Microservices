package Composite;

import java.util.List;

// The abstract class that stores the common properties of nodes in tree (Base Component)
public abstract class EntityNode {
    int salary, ID;
    String name;

    // This constructor will be used to take parameters in sub-classes as well
    protected EntityNode(int salary, int ID, String name) {
        this.salary = salary;
        this.ID = ID;
        this.name = name;
    }

    protected abstract void extract(); // Abstract method to be overriden in every subclass

    protected int getSalary() {
        return this.salary;
    }

    protected String getName() {
        return this.name;
    }

    protected int getID() {
        return this.ID;
    }

    // This will be overriden in Composite class
    protected List<EntityNode> getChildren() {
        return List.of(); // Returns the list (here empty)
    }
}
