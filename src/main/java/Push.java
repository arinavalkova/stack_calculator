import org.apache.log4j.Logger;

public class Push implements Factory
{
    private static final Logger log = Logger.getLogger(Push.class);

    private final String firstParam;
    private final Storage storage;

    public Push(String[] arguments, Storage storage)
    {
        firstParam = arguments[Consts.FIRST];
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        Double number;

        if(Tools.isNumeric(firstParam))
        {
            number = Double.parseDouble(firstParam);
        }
        else
        {
            number = storage.getParametersListController().searchValueInMap(firstParam);
        }

        log.info("PUSH " + number);

        storage.getStackController().putOnStack(number);
    }
}
