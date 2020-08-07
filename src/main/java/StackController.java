import org.apache.log4j.Logger;

import java.util.ArrayList;

public class StackController
{
    private static final Logger log = Logger.getLogger(StackController.class);
    private final ArrayList<Double> stack = new ArrayList<>();

    public void putOnStack(Double number) throws MyException
    {
        stack.add(Consts.FIRST, number);
        log.info("Put on stack: " + getFirstFromStack());
    }

    public Double getFirstFromStack() throws MyException
    {
        if(stack.isEmpty())
        {
            log.info(Consts.STACK_EMPTY);
            throw new MyException(Consts.STACK_EMPTY);
        }
        return stack.get(Consts.FIRST);
    }

    public Double popFromStack() throws MyException
    {
        if(stack.isEmpty())
        {
            log.info(Consts.STACK_EMPTY);
            throw new MyException(Consts.STACK_EMPTY);
        }

        log.info("Pop from stack: " + getFirstFromStack());

        Double answer = stack.get(Consts.FIRST);
        stack.remove(Consts.FIRST);

        return answer;
    }

    public void checkIsStackEmpty() throws MyException
    {
        if(stack.isEmpty())
        {
            log.info(Consts.STACK_EMPTY);
            throw new MyException(Consts.STACK_EMPTY);
        }
    }

    public void checkIsStackSizeBinary() throws MyException
    {
        if(stack.size() < 2)
        {
            log.info(Consts.NOT_ENOUGH_ELEMENTS);
            throw new MyException(Consts.NOT_ENOUGH_ELEMENTS);
        }
    }
}
