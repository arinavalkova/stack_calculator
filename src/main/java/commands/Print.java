package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.MyException;

public class Print implements Factory
{
    private static final Logger log = Logger.getLogger(Print.class);
    private final Storage storage;

    public Print(String[] arguments, Storage storage)
    {
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        Double number = storage.getStackController().getFirstFromStack();

        log.info("Printed: " + number);

        System.out.println(number);
    }
}