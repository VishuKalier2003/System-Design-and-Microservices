package Composite;

public abstract class EntityNode {
    int salary, ID;
    String name;

    protected EntityNode(int salary, int ID, String name) {
        this.salary = salary;
        this.ID = ID;
        this.name = name;
    }

    protected abstract void extract();

    protected int getSalary() {return this.salary;}
    protected String getName() {return this.name;}
    protected  int getID() {return this.ID;}
}
