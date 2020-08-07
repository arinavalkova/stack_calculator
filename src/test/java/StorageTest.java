import org.apache.log4j.Logger;
import org.junit.Test;
import storage.Storage;
import tools.MyException;

import static org.junit.Assert.assertEquals;

public class StorageTest
{
    private static final Logger log = Logger.getLogger(StorageTest.class);

    @Test
    public void putOnStack() throws MyException
    {
        log.info("PUT ON STACK FUNCTION TEST IS STARTING!");
        Double expected = Math.random();

        Storage storage = new Storage();
        storage.getStackController().putOnStack(expected);

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("PUT ON STACK FUNCTION TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }

    @Test
    public void popFromStack() throws MyException
    {
        log.info("POP FROM STACK FUNCTION IS TESTING");

        Double firstNumber = Math.random();
        Double secondNumber = Math.random();

        Storage storage = new Storage();

        storage.getStackController().putOnStack(firstNumber);

        storage.getStackController().putOnStack(secondNumber);

        storage.getStackController().popFromStack();

        assertEquals(storage.getStackController().getFirstFromStack(), firstNumber);

        log.info("POP ON STACK FUNCTION TEST HAS DONE");
        log.info("//////////////////////////////////////////////");
    }
}