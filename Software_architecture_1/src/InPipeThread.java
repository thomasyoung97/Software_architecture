import java.io.*;

public class InPipeThread extends Thread
{
    PipedWriter PipeIn;

    InPipeThread (PipedWriter PlaceInPipe)
    {
        PipeIn=PlaceInPipe;
    }

    public void run()
    {
        try
        {
            String Input, Filename;
            Filename = "input.txt";

            BufferedReader TheInput = new BufferedReader(new FileReader(Filename));

            while((Input=TheInput.readLine())!=null)
            {
                System.out.println(Input);
                System.out.println("\n");
                PipeIn.write(Input);
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("NO FILE ");
        }
        catch(IOException e)
        {
            System.out.println("NO I/O In Thread");
        }
    }
}

