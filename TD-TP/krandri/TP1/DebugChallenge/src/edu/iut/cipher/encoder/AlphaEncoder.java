package edu.iut.cipher.encoder;

import java.io.File;
import java.io.IOException;

import edu.iut.exceptions.EncodeException;

public class AlphaEncoder extends edu.iut.cipher.file.FileManager implements FileEncoder {

    
    public AlphaEncoder()
    {}

    
    @Override
    public void encode(File source, File destination, String key) throws EncodeException{
        if (!source.exists())
        {
            throw new EncodeException("File '"+source+"' does not exist.");
        }
        if (!source.isFile())
        {
            throw new EncodeException("'"+source+"' is not a file.");
        }
        if (!source.canRead())
        {
            throw new EncodeException("File '"+source+"' is not readable.");
        }
        byte[] sourceData = read(source);
        byte[] destinationData = generateKey(key,sourceData.length-1);
        for (int si = 0;si<sourceData.length;si++)
        {
            int xorb = sourceData[si] ^ destinationData[si];
            destinationData[si] = (byte)(xorb & 0xff);
        }
        try
        {
        	write(destinationData,destination);
        }
        catch(IOException ioException)
        {
        	throw new EncodeException(ioException.toString());
        }

    }
    
}

