
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Printer {
    private final StringBuilder output;
    private final PrintWriter writer;

    public Printer() {
        this.output = new StringBuilder();
        this.writer = new PrintWriter(new OutputStreamWriter(System.out));
    }

    public void printLine(String sentence) {
        output.append(sentence).append("\n");
        writer.write(output.toString());
        writer.flush();
        output.delete(0, output.length());
    }

    public void dashLine() {
        output.append("----------------------------");
        writer.write(output.toString());
        writer.flush();
        output.delete(0, output.length());
    }
}
