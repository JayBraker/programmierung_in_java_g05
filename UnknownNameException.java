package abgabe3;

public class UnknownNameException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = -2342254946845828131L;

    public UnknownNameException(String errorMessage)
    {
        super(errorMessage);
    }
}
