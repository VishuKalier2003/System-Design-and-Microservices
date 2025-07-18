
@FunctionalInterface
public interface Handler {

    public Pipe operateAndTransfer(String... data) throws Exception;
}
