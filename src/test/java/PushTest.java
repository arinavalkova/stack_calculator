import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class PushTest
{
    private static final Logger log = Logger.getLogger(PushTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("PUSH TEST IS STARTING!");

        Double firstElement = Math.random();
        Double secondElement = Math.random();

        String[] firstParameter = new String[]{"a", Double.toString(firstElement)};
        String[] secondParameter = new String[]{Double.toString(secondElement)};
        String[] thirdParameter = new String[]{"a"};

        Storage storage = new Storage();

        Define define = new Define(firstParameter, storage);
        define.doWork();

        Push push = new Push(thirdParameter, storage);
        push.doWork();

        assertEquals(storage.getStackController().getFirstFromStack(), firstElement);

        push = new Push(secondParameter, storage);
        push.doWork();

        assertEquals(storage.getStackController().getFirstFromStack(), secondElement);

        log.info("PUSH TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}