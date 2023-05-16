package exception;

//Runtime Exception
public class FatalException extends RuntimeException {
    public FatalException() {
        super("This is a very strong Exception, you can do nothing");
    }
}
