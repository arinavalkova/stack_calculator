import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest
{
    private static final Logger log = Logger.getLogger(SqrtTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("SQRT TEST IS STARING!");
        Double number = Math.random();
        Double expected = Math.sqrt(number);

        String[] firstArguments = new String[]{Double.toString(number)};
        String[] secondArguments = null;

        Storage storage = new Storage();

        Push push = new Push(firstArguments, storage);
        push.doWork();

        Sqrt sqrt = new Sqrt(secondArguments, storage);
        sqrt.doWork();

        assertEquals(storage.getStackController().getFirstFromStack(), expected);

        log.info("SQRT TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}