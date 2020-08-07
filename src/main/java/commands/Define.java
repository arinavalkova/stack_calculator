package commands;

import org.apache.log4j.Logger;
import storage.Storage;
import tools.Consts;
import tools.MyException;
import tools.Tools;

public class Define implements Factory
{
    private static final Logger log = Logger.getLogger(Define.class);

    private final String firstParam;
    private final String secondParam;
    private final Storage storage;

    public Define(String[] arguments, Storage storage)
    {
        firstParam = arguments[Consts.FIRST];
        secondParam = arguments[Consts.ONE];
        this.storage = storage;
    }

    @Override
    public void doWork() throws MyException
    {
        if(Tools.isNumeric(firstParam))
        {
            log.info(Consts.BAD_ARGUMENTS);
            throw new MyException(Consts.BAD_ARGUMENTS);
        }

        Double secondParamDouble;
        if(Tools.isNumeric(secondParam))
        {
            secondParamDouble = Double.parseDouble(secondParam);
        }
        else
        {
            secondParamDouble = storage.getParametersListController().searchValueInMap(secondParam);
        }

        storage.getParametersListController().addParameter(firstParam, secondParamDouble);

        log.info("Added to map: " + firstParam + " and " + secondParamDouble);

    }
}