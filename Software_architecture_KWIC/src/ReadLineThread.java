import java.io.*;

public class ReadLineThread extends Thread
{
    private PipedWriter Pipein;

    ReadLineThread (PipedWriter PutinPipe)
    {
        this.Pipein = PutinPipe;
    }

    public void run()
    {
        try
        {

            String FileName = "kwic.dat";

            BufferedReader inputBuffer = new BufferedReader(new FileReader(FileName));

            while(inputBuffer.ready())
            {
                String line = inputBuffer.readLine();
                Pipein.write(line + "\n");
                System.out.println(line);
                Pipein.flush();

            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("NO FILE");
        }
        catch(IOException e)
        {
            System.out.println("fuck theres no IO");
        }

    }
}
