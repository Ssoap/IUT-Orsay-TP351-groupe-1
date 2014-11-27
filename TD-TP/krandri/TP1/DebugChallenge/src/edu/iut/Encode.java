package edu.iut;

import edu.iut.cipher.encoder.AlphaEncoder;
import edu.iut.cipher.encoder.FileEncoder;
import edu.iut.exceptions.EncodeException;

import java.io.File;

public class Encode {

	private static int ATTRIBUTE = 1;
    private static int VALUE     = 2;
    
    public void usage()
    {
        System.err.println("edu.iut.Decode --input-file=<file> --output-file=<file> --key=<secret key>");
    }
    
    private void encode(String source,String destination, String key)
    {
        FileEncoder encoder = null;
        encoder = new AlphaEncoder();
        try
        {
            encoder.encode(new File(source), new File(destination), key);
        }
        catch(EncodeException encodeException)
        {
            System.err.println(encodeException);
        }
    }
    
    public static void main(String[] args) {
        Encode encoder     = new Encode();
        String source      = null;
        String destination = null;
        String key         = null;
        if (args.length == 0)
        {
            encoder.usage();
            return;
        }
        for (int argi = 0;argi<args.length;argi++)
        {
            String[] attributeValue = args[argi].split("=");
            try
            {
                if (attributeValue.length == 2)
                {
                    if (attributeValue[Encode.ATTRIBUTE] == "--input-file")
                    {
                        source = attributeValue[Encode.VALUE];
                    }
                    else if (attributeValue[Encode.ATTRIBUTE] == "--output-file")
                    {
                        destination = attributeValue[Encode.VALUE];
                    }
                    else if (attributeValue[Encode.ATTRIBUTE] == "--key")
                    {
                        key = attributeValue[Encode.VALUE];
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
                encoder.usage();
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
        encoder.encode(source, destination, key);
    }


}
