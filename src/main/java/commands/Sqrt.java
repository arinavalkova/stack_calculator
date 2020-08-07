package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.MyException;

import static java.lang.Math.sqrt;

public class Sqrt implements Factory
{
    private static final Logger log = Logger.getLogger(Sqrt.class);
    private final Storage storage;

    public Sqrt(String[] arguments, Storage storage)
    {
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        storage.getStackController().checkIsStackEmpty();
        Double firstElement = storage.getStackController().popFromStack();

        log.info("SQRT");

        storage.getStackController().putOnStack(sqrt(firstElement));
    }
}
