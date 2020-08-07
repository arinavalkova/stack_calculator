import storage.Storage;
import tools.Consts;
import tools.MyException;
import tools.Tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calculator
{
    public static void main(String[] args)
    {
        BufferedReader reader = getReader(args);
        readLinesAndExecute(reader);
    }

    private static BufferedReader getReader(String[] args)
    {
        if (args.length != 0)
        {
            InputStream input = Tools.class.getResourceAsStream(args[Consts.FIRST]);
            return new BufferedReader(new InputStreamReader(input));
        }

        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static void readLinesAndExecute(BufferedReader reader)
    {
        Storage storage = new Storage();
        String line;

        while (true)
        {
            line = Tools.readLine(reader);
            if (Tools.isLineEmpty(line))
                break;

            workWithLine(line, storage);
        }
    }

    private static void workWithLine(String line, Storage storage)
    {
        try
        {
            Tools.allWorksWithLine(line, storage);
        } catch (MyException e)
        {
            System.out.println(e.getLineOfMistake());
        }
    }
}