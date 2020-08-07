package storage;

public class Storage
{
    private final ParametersListController parametersListController = new ParametersListController();
    private final StackController stackController = new StackController();

    public ParametersListController getParametersListController()
    {
        return parametersListController;
    }

    public StackController getStackController()
    {
        return stackController;
    }
}
