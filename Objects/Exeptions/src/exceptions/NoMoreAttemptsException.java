package exceptions;

public class NoMoreAttemptsException extends Exception
{
    public NoMoreAttemptsException(String message)
    {
        super(message);
    }
}
