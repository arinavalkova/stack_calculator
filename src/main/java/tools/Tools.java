package tools;

import org.apache.log4j.Logger;
import storage.Storage;
import commands.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Tools
{
    private static final Logger log = Logger.getLogger(Tools.class);

    public static boolean isNumeric(String line)
    {
        for (char c : line.toCharArray())
        {
            if (!Character.isDigit(c) && c != Consts.DOT && c != Consts.COMMA)
            {
                return false;
            }
        }
        return true;
    }

    public static void allWorksWithLine(String line, Storage storage) throws MyException
    {
        line = deleteMessAfterLattice(line);
        isLineEmptyException(line);
        splitLineAndWork(line, storage);
    }

    private static String deleteMessAfterLattice(String line)
    {
        return line.split(Consts.STRING_LATTICE, Consts.LIMIT)[Consts.FIRST];
    }

    public static void isLineEmptyException(String line) throws MyException
    {
        if (line.isEmpty())
        {
            log.info(Consts.EMPTY_LINE);
            throw new MyException(Consts.EMPTY_LINE);
        }
    }

    private static void splitLineAndWork(String line, Storage storage) throws MyException
    {
        String[] arraySplitLine = line.split(Consts.SPACE);

        String[] arguments = getArguments(arraySplitLine);
        String nameOfClass = getNameOfClass(arraySplitLine);

        checkCountOfArgsForClass(nameOfClass, arguments.length);

        Class<?> loadedClass = loadClass(nameOfClass);
        Class[] params = {String[].class, Storage.class};

        Factory factory = getFactory(loadedClass, params, arguments, storage);
        factory.doWork();
    }

    private static String[] getArguments(String[] arraySplitLine)
    {
        String[] arguments = new String[arraySplitLine.length - Consts.ONE];
        System.arraycopy(arraySplitLine, Consts.ONE, arguments, Consts.FIRST, arraySplitLine.length - Consts.ONE);

        return arguments;
    }

    private static String getNameOfClass(String[] arrayOfWords) throws MyException
    {
        String command = arrayOfWords[Consts.FIRST];
        String nameOfClass = Tools.findNameOfClass(command);
        isNameOfClassEmpty(nameOfClass);

        return nameOfClass;
    }

    public static String findNameOfClass(String nameOfOperation)
    {
        File file = new File("src/main/resources/Configuration.TXT");;
        InputStream input = null;
        try
        {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line;
        while (true)
        {
            line = readLine(reader);
            if (isLineEmpty(line))
                break;

            String[] arrayOfSplitLine = line.split(Consts.SPACE);
            if (arrayOfSplitLine[Consts.FIRST].equals(nameOfOperation))
            {
                closeInputStream(input);
                closeBufferedReader(reader);

                return arrayOfSplitLine[Consts.ONE];
            }
        }

        closeInputStream(input);
        closeBufferedReader(reader);

        return null;
    }

    private static void closeInputStream(InputStream input)
    {
        try
        {
            input.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void closeBufferedReader(BufferedReader reader)
    {
        try
        {
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String readLine(BufferedReader reader)
    {
        String line = null;
        try
        {
            line = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return line;
    }

    public static boolean isLineEmpty(String line)
    {
        return line == null;
    }

    private static void isNameOfClassEmpty(String nameOfClass) throws MyException
    {
        if (nameOfClass == null)
        {
            log.info(Consts.BAD_NAME_OF_COMMAND);
            throw new MyException(Consts.BAD_NAME_OF_COMMAND);
        }
    }

    private static void checkCountOfArgsForClass(String nameOfClass, int length) throws MyException
    {
        if (countOfArgs.get(nameOfClass) != length)
        {
            log.info(Consts.BAD_COUNT_OF_ARGS);
            throw new MyException(Consts.BAD_COUNT_OF_ARGS);
        }
    }

    private static Factory getFactory(Class<?> loadedClass, Class[] params, String[] arguments, Storage storage)
    {
        Factory factory = null;
        try
        {
            factory = (Factory) loadedClass.getConstructor(params).newInstance((Object) arguments, storage);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        return factory;
    }

    private static Class<?> loadClass(String nameOfClass)
    {
        Class<?> loadedClass = null;
        try
        {
            loadedClass = Class.forName(nameOfClass);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return loadedClass;
    }

    private static final Map<String, Integer> countOfArgs = Map.of(
            "commands.Define", 2,
            "commands.Pop", 0,
            "commands.Push", 1,
            "commands.Print", 0,
            "commands.Sqrt", 0,
            "commands.Addition", 0,
            "commands.Subtraction", 0,
            "commands.Multiplication", 0,
            "commands.Division", 0
    );
}
