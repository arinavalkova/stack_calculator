import commands.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import storage.Storage;
import tools.MyException;

import static org.junit.Assert.assertEquals;

public class AdditionTest
{
    private static final Logger log = Logger.getLogger(AdditionTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("STARTING ADDITION TEST!");

        double firstElement = Math.random();
        double secondElement = Math.random();

        String[] firstParameters = new String[]{Double.toString(firstElement)};
        String[] secondParameters = new String[]{Double.toString(secondElement)};

        Storage storage = new Storage();

        Push push = new Push(firstParameters, storage);
        push.doWork();

        push = new Push(secondParameters, storage);
        push.doWork();

        firstParameters = null;
        Addition addition = new Addition(firstParameters, storage);
        addition.doWork();

        Double expected = firstElement + secondElement;

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("ADDITION TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}

