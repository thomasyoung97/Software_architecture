import java.util.*;
import java.io.*;

public class SortLineThread extends Thread
{
    private PipedReader PipeIn;
    ArrayList<String> KWICstore = new ArrayList<>();

    SortLineThread (PipedReader pullIn)
    {
        this.PipeIn = pullIn;
    }

    public void run()
    {
        try
        {
            BufferedReader InputBuffer = new BufferedReader(PipeIn);

            while(true)
            {
                String Line = InputBuffer.readLine();
                KWICstore.add(Line);
            }

        }
        catch(IOException e)
        {
            System.out.print("NO IO" + "\n");
        }

        Collections.sort(KWICstore);

        for (int i = 0; i < KWICstore.size(); i++)
            System.out.println(KWICstore.get(i));
        System.out.println("hit");
    }


}


