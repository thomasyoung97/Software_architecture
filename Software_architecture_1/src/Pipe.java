import java.io.*;



public class Pipe
{
    public static void main (String[] args)
        {
            try
            {
                PipedReader Extract = new PipedReader();
                PipedWriter Insert = new PipedWriter(Extract);
                InPipeThread R1 = new InPipeThread(Insert);
                OutPipeThread R2 = new OutPipeThread(Extract);
                R1.start();
                R2.start();

            }
            catch(IOException e)
            {
                System.out.println("NO I/O");
            }
        }
    }

