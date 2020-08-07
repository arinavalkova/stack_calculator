import org.apache.log4j.Logger;

public class Addition implements Factory
{
    private static final Logger log = Logger.getLogger(Addition.class);
    private final Storage storage;

    public Addition(String[] arguments, Storage storage)
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

        log.info("ADDITION");

        storage.getStackController().putOnStack(firstElement + secondElement);
    }
}
