import java.io.*;


public class Pipes
{
    public static void main (String[] args)
    {
        try
        {
            PipedReader pipeOutA = new PipedReader();
            PipedWriter pipeInA = new PipedWriter(pipeOutA);
            PipedReader pipeOutB = new PipedReader();
            PipedWriter pipeInB = new PipedWriter(pipeOutB);

            ReadLineThread read = new ReadLineThread(pipeInA);
            ShiftThread shift = new ShiftThread(pipeOutA,pipeInB);
           // SortLineThread sort = new SortLineThread(pipeOutA,pipeInB);

            read.start();
            shift.start();

        }
        catch(IOException e)
        {
            System.out.print("NO I/O");
        }
    }
}
