package Practice.Decorator.TextFormatter;

@SuppressWarnings("unused")
public class HtmlText extends TextDecorator {

    HtmlText(TextDecorator interfaceText) {
        super(interfaceText);
    }

    private static int j;

    @Override
    public String formatText(String text) {
        StringBuilder output = new StringBuilder();
        int n = text.length();
        for (j = 0; j < n; j++) {
            char ch = text.charAt(j);
            if (ch == '<')
                output.append(extractTag(text));
        }
        return output.toString();
    }

    private String extractTag(String text) {
        char ch = '<';
        StringBuilder tag = new StringBuilder();
        while (ch != '>') {
            tag.append(text.charAt(++j));
            ch = text.charAt(j);
        }
        ++j;
        return tag.append("\" ").toString();
    }
}
