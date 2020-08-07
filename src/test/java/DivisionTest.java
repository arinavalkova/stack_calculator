import commands.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import storage.Storage;
import tools.MyException;

import static org.junit.Assert.assertEquals;

public class DivisionTest
{
    private static final Logger log = Logger.getLogger(DivisionTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("STARTING DIVISION TEST!");

        double firstElement = Math.random();
        double secondElement = Math.random();

        String[] firstParameters= new String[]{Double.toString(firstElement)};
        String[] secondParameters = new String[]{Double.toString(secondElement)};

        Storage storage = new Storage();

        Push push = new Push(firstParameters, storage);
        push.doWork();

        push = new Push(secondParameters, storage);
        push.doWork();

        firstParameters = null;
        Division division = new Division(firstParameters, storage);
        division.doWork();

        Double expected = firstElement / secondElement;

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("DIVISION TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}