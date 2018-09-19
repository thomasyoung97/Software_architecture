import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.StringTokenizer;

public class ShiftThread extends Thread {
    private PipedReader pipeIn;
    private PipedWriter pipeOut;


    ShiftThread(PipedReader ExtractPipe, PipedWriter PushPipe) {
        this.pipeIn = ExtractPipe;
        this.pipeOut = PushPipe;
    }

    public void run()
    {
        try {
            BufferedReader inputBuffer = new BufferedReader(pipeIn);

            while (true)
            {
                String Line = inputBuffer.readLine();

                StringTokenizer tokenizer = new StringTokenizer(Line, ",.:()");

                String[] tokens = new String[tokenizer.countTokens()];

                for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                    tokens[i] = tokenizer.nextToken();
                }
                System.out.println(tokens[0]);

            }
        }
        catch(IOException ioe)
        {
                System.out.println("END");
        }

    }
}