package Composite;

import Singleton.SingletonWriter;

// This is the leaf class, building block of composition and defines behaviour for the elements
public class Manager extends EntityNode {
    // Other non-common parameters defined
    protected int parentID;

    public Manager(int salary, int ID, String name, int pID) {
        super(salary, ID, name); // Super keyword to take arguments from the parent
        this.parentID = pID;
    }

    @Override
    protected void extract() {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("Parent ID : " + getParentID());
        SingletonWriter.getInstance().printLine("ID : " + getID());
        SingletonWriter.getInstance().printLine("Name : " + getName());
        SingletonWriter.getInstance().printLine("Salary : " + getSalary());
    }

    public int getParentID() {
        return this.parentID;
    }
}
