import java.io.*;

public class OutPipeThread extends Thread
{
    PipedReader PipeOut;

    OutPipeThread(PipedReader ReadFromPipe)
    {
        PipeOut=ReadFromPipe;
    }

    public void run()
    {

        char[] cbuf = new char[80];

        int i,j;
        String line = "Empty";
        StringBuffer linebuff = new StringBuffer (80);
        try
        {

            PrintWriter  FileOut = new PrintWriter (new BufferedWriter(new FileWriter("Output.txt")));

            i = PipeOut.read (cbuf, 0, 80);

            while( i != -1)
            {
                linebuff.setLength(i);

                for (j = 0; j<i;j++) linebuff.setCharAt(j,  cbuf[j]);

                line = linebuff.toString();

                System.out.println("O/P Pipe:" +line+"\n");
                FileOut.println(line + "\n");
                FileOut.flush();

                i = PipeOut.read(cbuf,0,80); //get next buffer's worth
            }

        }catch(FileNotFoundException e)
        {
            System.out.println("NO FILE ");
        }
        catch(IOException e)
        {
            System.out.println("NO I/O Out Thread");
        }
    }
}


