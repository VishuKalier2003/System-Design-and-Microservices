package Practice.Decorator.TextFormatter;

// Base class on which the decorations will be levaraged
public class BaseText implements Text {

    @Override
    public String formatText(String text) {
        return text; // return raw text
    }
}
