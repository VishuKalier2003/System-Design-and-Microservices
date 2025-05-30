package Practice.Decorator.TextFormatter;

import Singleton.SingletonWriter;
import java.util.Scanner;

// Test : <hi"hello" <"by"e>> , <hi"hello <how>" "<are you>">

public class Test {
    public static void main(String[] args) {
        BaseText obj1 = new BaseText();
        HtmlText dec1 = new HtmlText(new TextDecorator(obj1));
        MarkdownText dec2 = new MarkdownText(new TextDecorator(obj1));
        MarkdownText layered = new MarkdownText(new HtmlText(new TextDecorator(obj1)));
        HtmlText layered2 = new HtmlText(new HtmlText(new TextDecorator(obj1)));
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            SingletonWriter.getInstance().printLine("Base Class Formatting : " + obj1.formatText(input));
            SingletonWriter.getInstance().printLine("Html Text Class Formatting : " + dec1.formatText(input));
            SingletonWriter.getInstance().printLine("Markdown Text Class Formatting : " + dec2.formatText(input));
            SingletonWriter.getInstance().printLine("Layered Class Formatting : " + layered.formatText(input));
            sc.close();
        }
    }
}
