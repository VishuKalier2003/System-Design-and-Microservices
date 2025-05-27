package Singleton;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

public class Data {     // Info: Test class to store data
    private final int ID;
    private final String hashCode, log;

    public Data(int id, String log) {
        this.ID = id;
        this.log = log;
        this.hashCode = new Date().toInstant().toString()+"ID"+this.ID;
    }

    // Info: Getter functions
    public int getID() {return this.ID;}
    public String getHashCode() {return this.hashCode;}
    public String getLog() {return this.log;}

    public void print() {       // Print function to display object data fetched
        final StringBuilder output = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        output.append("Data ID : ").append(getID()).append("\n");
        output.append("Data Hash code : ").append(getHashCode()).append("\n");
        output.append("Data Log : ").append(getLog()).append("\n");
        writer.write(output.toString());
        writer.flush();
    }
}
