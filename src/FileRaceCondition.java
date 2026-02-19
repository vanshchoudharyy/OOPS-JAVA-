import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileRaceCondition
{
    public static void main(String[] args)
    {
        String fileName = "output.txt";
        Runnable task1 = () -> writeToFile(fileName, "APPLE ");
        Runnable task2 = () -> writeToFile(fileName, "ORANGE ");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        System.out.println("Starting threads... check output.txt for the mess.");
        try{
            t1.start();
            t1.join();
            t2.start();
        }
        catch(Exception e )
        {
            System.out.println( e );
        }
    }

    private static void writeToFile(String fileName, String content)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true)))
        {
            for (int i = 0; i < 1000; i++)
            {
                writer.print(content);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}