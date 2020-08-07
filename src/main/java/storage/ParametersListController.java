package storage;

import org.apache.log4j.Logger;
import tools.Consts;
import tools.MyException;

import java.util.HashMap;
import java.util.Map;

public class ParametersListController
{
    private static final Logger log = Logger.getLogger(ParametersListController.class);

    private final Map<String, Double> parametersList = new HashMap<>();

    public void addParameter(String parameter, Double value)
    {
        parametersList.put(parameter, value);
    }

    public Double searchValueInMap(String key) throws MyException
    {
        if(parametersList.get(key) == null)
        {
            log.info(Consts.BAD_PARAMETER);
            throw new MyException(Consts.BAD_PARAMETER);
        }
        return parametersList.get(key);
    }
}
