import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationTest
{
    private static final Logger log = Logger.getLogger(MultiplicationTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("STARTING MULTIPLICATION TEST!");

        double firstElement = Math.random();
        double secondElement = Math.random();

        String[] firstParameters= new String[]{Double.toString(firstElement)};
        String[] secondParameters = new String[]{Double.toString(secondElement)};

        Storage storage = new Storage();

        Push push = new Push(firstParameters, storage);
        push.doWork();

        push = new Push(secondParameters, storage);
        push.doWork();

        firstParameters= null;
        Multiplication multiplication = new Multiplication(firstParameters, storage);
        multiplication.doWork();

        Double expected = firstElement * secondElement;

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("MULTIPLICATION TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}