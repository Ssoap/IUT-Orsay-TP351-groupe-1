package edu.iut;

import edu.iut.cipher.decoder.*;
import edu.iut.exceptions.DecodeException;

import java.io.File;

public class Decode {

	private static int ATTRIBUTE = 0;
    private static int VALUE     = 1;
    
    public void usage()
    {
        System.err.println("edu.iut.Decode --input-file=<file> --output-file=<file> --key=<secret key>");
    }
    
    private void decode(String source, String destination, String key)
    {
        FileDecoder aDecoder = new AlphaDecoder();
        try
        {
        	aDecoder.decode(new File(source), new File(destination), key);
        }
        catch(DecodeException decodeException)
        {
        	System.err.println(decodeException);
        }
    }
    
    public static void main(String[] args) {
        Decode decoder = new Decode();
        String source = null;
        String destination = null;
        String key = null;
        for (int argi = 0;argi<args.length;argi++)
        {
            String[] attributeValue = args[argi].split("=");
            try
            {
                if (attributeValue.length == 2)
                {
                	if (attributeValue[Decode.ATTRIBUTE].equals("--input-file"))
                    {
                        source = attributeValue[Decode.VALUE];
                    }
                    else if (attributeValue[Decode.ATTRIBUTE].equals("--output-file"))
                    {
                        destination = attributeValue[Decode.VALUE];
                    }
                    else if (attributeValue[Decode.ATTRIBUTE].equals("--key"))
                    {
                        key = attributeValue[Decode.VALUE];
                    }
                }
                else 
                {
                    throw new edu.iut.exceptions.ProgramArgumentException("Error parse arguments");
                }
            }
            catch(edu.iut.exceptions.ProgramArgumentException ex)
            {
                System.err.println(ex);
                decoder.usage();
                return;
            }
            catch(Exception ex2)
            {
                System.err.println(ex2);
                return;
            }
            
        }
        System.err.println("Source file:"+source);
        System.err.println("Destination file:"+destination);
        System.err.println("Key:"+key);
        decoder.decode(source, destination, key);
    }

}
