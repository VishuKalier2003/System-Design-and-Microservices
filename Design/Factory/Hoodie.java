import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Hoodie extends Clothes {

    public Hoodie(String fabric, String brand, String color, boolean cap) {
        super(fabric);      // property called from parent class
        this.brand = brand;
        this.color = color;
        this.cap = cap;
    }

    private final String brand, color;
    private final boolean cap;
    
    @Override
    public void extract() {
        final StringBuilder output = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        output.append("=======Shirt Data Extracted=======").append("\n");
        output.append("Fabric : ").append(this.fabric).append("\n");
        output.append("Brand : ").append(this.brand).append("\n");
        output.append("Color : ").append(this.color).append("\n");
        output.append("Cap : ").append(this.cap).append("\n");
        output.append("==================================").append("\n");
        writer.write(output.toString());
        writer.flush();
    }
}
