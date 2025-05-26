import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Shirt extends Clothes {
    public Shirt(String fabric, String brand, String color) {
        super(fabric);
        this.brand = brand;
        this.color = color;
    }

    private final String brand, color;
    
    @Override
    public void extract() {
        final StringBuilder output = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        output.append("=======Shirt Data Extracted=======").append("\n");
        output.append("Fabric : ").append(this.fabric).append("\n");
        output.append("Brand : ").append(this.brand).append("\n");
        output.append("Color : ").append(this.color).append("\n");
        output.append("==================================").append("\n");
        writer.write(output.toString());
        writer.flush();
    }
}
