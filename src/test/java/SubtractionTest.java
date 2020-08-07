import commands.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import storage.Storage;
import tools.MyException;

import static org.junit.Assert.assertEquals;

public class SubtractionTest
{
    private static final Logger log = Logger.getLogger(SubtractionTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("STARTING SUBTRACTION TEST!");

        Double firstElement = Math.random();
        Double secondElement = Math.random();

        String[] firstParameter = new String[]{Double.toString(firstElement)};
        String[] secondParameter = new String[]{Double.toString(secondElement)};

        Storage storage = new Storage();

        Push push = new Push(firstParameter, storage);
        push.doWork();

        push = new Push(secondParameter, storage);
        push.doWork();

        firstParameter = null;
        Subtraction subtraction = new Subtraction(firstParameter, storage);
        subtraction.doWork();

        Double expected = firstElement - secondElement;

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("SUBTRACTION TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}