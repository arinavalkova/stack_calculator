public class MyException extends Throwable
{
    private final String lineOfMistake;

    public MyException(String mistake)
    {
        lineOfMistake = mistake;
    }

    public String getLineOfMistake()
    {
        return lineOfMistake;
    }
}
