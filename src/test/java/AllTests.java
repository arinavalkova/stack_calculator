import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ToolsTest.class, AdditionTest.class, StorageTest.class, DefineTest.class,
        DivisionTest.class, MultiplicationTest.class, PopTest.class, PushTest.class,
        SqrtTest.class, SubtractionTest.class})
@RunWith(Suite.class)
public class AllTests
{
}
