package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.MyException;

public class Division implements Factory
{
    private static final Logger log = Logger.getLogger(Division.class);
    private final Storage storage;

    public Division(String[] arguments, Storage storage)
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

        log.info("DIVISION");

        storage.getStackController().putOnStack(secondElement / firstElement);

    }
}
