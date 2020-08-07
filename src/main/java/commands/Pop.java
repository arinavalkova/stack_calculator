package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.MyException;

public class Pop implements Factory
{
    private static final Logger log = Logger.getLogger(Pop.class);
    private final Storage storage;

    public Pop(String[] arguments, Storage storage)
    {
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        storage.getStackController().checkIsStackEmpty();

        log.info("Pop from stack: " + storage.getStackController().getFirstFromStack());

        storage.getStackController().popFromStack();

    }
}
