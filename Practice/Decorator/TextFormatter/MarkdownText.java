package Practice.Decorator.TextFormatter;

@SuppressWarnings("unused")
public class MarkdownText extends TextDecorator {

    MarkdownText(Text text) { // Calls the Parent Decorator
        super(text);
    }

    // Used within the class hence declared private
    private static int j;

    @Override
    public String formatText(String text) {
        int n = text.length();
        StringBuilder output = new StringBuilder();
        for (j = 0; j < n; j++) {
            char ch = text.charAt(j);
            if (ch == '"')
                output.append(extractMarkdown(text));
        }
        return output.toString();
    }

    private String extractMarkdown(String text) {
        j++;
        StringBuilder markdown = new StringBuilder();
        char ch = text.charAt(j);
        while (ch != '"') {
            markdown.append(ch);
            ch = text.charAt(j++);
        }
        return markdown.append(" ").substring(1);
    }
}
