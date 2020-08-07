import commands.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import storage.Storage;
import tools.MyException;

import static org.junit.Assert.assertEquals;

public class PopTest
{
    private static final Logger log = Logger.getLogger(PopTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("POP TEST IS STARTING!");

        Double firstElement = Math.random();
        Double secondElement = Math.random();

        String[] firstParameters= new String[]{Double.toString(firstElement)};
        String[] secondParameters = new String[]{Double.toString(secondElement)};
        String[] thirdParameters = null;

        Storage storage = new Storage();

        Push push1 = new Push(firstParameters, storage);
        push1.doWork();

        Push push2 = new Push(secondParameters, storage);
        push2.doWork();

        Pop pop = new Pop(thirdParameters, storage);
        pop.doWork();

        assertEquals(storage.getStackController().getFirstFromStack(), firstElement);

        log.info("POP TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}