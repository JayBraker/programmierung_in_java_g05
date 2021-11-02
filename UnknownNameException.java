package abgabe3;

/**
 * @author Selina Fiorin, Martin Albertz, Josha Bartsch
 *
 */
public class UnknownNameException extends RuntimeException
{
    /**
     * Custom exception as demanded by specification
     */
    private static final long serialVersionUID = -2342254946845828131L;

    public UnknownNameException(String errorMessage)
    {
        super(errorMessage);
    }
}
