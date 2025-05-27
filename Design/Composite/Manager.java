package Composite;

import Singleto

public class Manager extends EntityNode {
    protected int parentID;

    public Manager(int salary, int ID, String name, int pID) {
        super(salary, ID, name);
        this.parentID = pID;
    }

    @Override
    protected void extract() {
        SingletonWriter.getInstance().dashLine();
    }

    public int getParentID() {
        return this.parentID;
    }
}
