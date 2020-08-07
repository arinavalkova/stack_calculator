package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.MyException;

public class Multiplication implements Factory
{
    private static final Logger log = Logger.getLogger(Multiplication.class);
    private final Storage storage;

    public Multiplication(String[] arguments, Storage storage)
    {
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        storage.getStackController().checkIsStackEmpty();
        storage.getStackController().checkIsStackSizeBinary();

        Double firstElement = storage.getStackController().popFromStack();
        Double secondElement = storage.getStackController().popFromStack();

        log.info("MULTIPLICATION");

        storage.getStackController().putOnStack(firstElement * secondElement);
    }
}
