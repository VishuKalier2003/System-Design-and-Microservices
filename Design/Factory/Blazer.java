import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Blazer extends Clothes {
    public Blazer(String fabric, String brand, String color, boolean uniform) {
        super(fabric);
        this.brand = brand;
        this.color = color;
        this.uniform = uniform;
    }

    private final String brand, color;
    private final boolean uniform;
    
    @Override
    public void extract() {
        final StringBuilder output = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        output.append("=======Shirt Data Extracted=======").append("\n");
        output.append("Fabric : ").append(this.fabric).append("\n");
        output.append("Brand : ").append(this.brand).append("\n");
        output.append("Color : ").append(this.color).append("\n");
        output.append("Uniform Dress : ").append(this.uniform).append("\n");
        output.append("==================================").append("\n");
        writer.write(output.toString());
        writer.flush();
    }
}
