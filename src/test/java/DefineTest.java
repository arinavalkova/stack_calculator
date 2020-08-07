import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefineTest
{
    private static final Logger log = Logger.getLogger(DefineTest.class);

    @Test
    public void doWork() throws MyException
    {
        log.info("DEFINE TEST IS STARTING");

        double number = Math.random();

        Storage storage = new Storage();
        String[] arguments = new String[]{"a", Double.toString(number)};

        Define define = new Define(arguments, storage);
        define.doWork();

        Double expected = number;

        assertEquals(storage.getParametersListController().searchValueInMap("a"), expected);

        log.info("DEFINE TEST HAS DONE!");
        log.info("//////////////////////////////////////////////");
    }
}