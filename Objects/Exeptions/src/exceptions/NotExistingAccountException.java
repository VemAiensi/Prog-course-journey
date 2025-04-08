package exceptions;

public class NotExistingAccountException extends Exception
{//this exception class is just an extra feature
    public NotExistingAccountException(String message)
    {
        super(message);
    }
}
