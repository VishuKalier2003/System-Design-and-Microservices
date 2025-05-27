package Composite;

import Singleton.SingletonWriter;

public class Developer extends EntityNode {
    protected int parentID;
    protected String gender;

    public Developer(int salary, int ID, String name, int pID, String g) {
        super(salary, ID, name);
        this.gender = g;
        this.parentID = pID;
    }
    
    @Override
    protected void extract() {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("Parent ID : "+getParentID());
        SingletonWriter.getInstance().printLine("ID : "+getID());
        SingletonWriter.getInstance().printLine("Name : "+getName());
        SingletonWriter.getInstance().printLine("Gender : "+getGender());
        SingletonWriter.getInstance().printLine("Salary : "+getSalary());
    }

    public int getParentID() {
        return this.parentID;
    }

    public String getGender() {
        return this.gender;
    }
}
