package Practice.Decorator.TextFormatter;

// THe hierarachy of call goes from Concrete Decorator to Decorator Wrapper to Base Class
@SuppressWarnings("unused")
class TextDecorator implements Text { // This class is Decorator Wrapper

    protected Text basetext;

    private TextDecorator() {
    } // The fields cannot be made null

    // In constructor pass the base class not the interface
    public TextDecorator(Text text) {
        // Since both TextDecorator and BaseText implement same interface no need
        // type-cast
        this.basetext = text;
    }

    // The interface function in Decorator calls the interface function in BaseText
    // class as the first operation
    @Override
    public String formatText(String text) {
        return basetext.formatText(text);
    }
}
