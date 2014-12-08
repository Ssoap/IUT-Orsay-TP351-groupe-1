package edu.iut.cipher.decoder;

import edu.iut.cipher.file.FileManager;

import java.io.File;
import java.io.IOException;

import edu.iut.exceptions.DecodeException;


public class AlphaDecoder extends FileManager implements FileDecoder {
    
	public AlphaDecoder()
	{ 
		super(); 
	}
	
    @Override
    public void decode(File source, File destination, String key) throws DecodeException {
    	if (!source.exists())
        {
            throw new DecodeException("File '"+source+"' does not exist.");
        }
        if (!source.isFile())
        {
            throw new DecodeException("'"+source+"' is not a file.");
        }
        if (!source.canRead())
        {
            throw new DecodeException("File '"+source+"' is not readable.");
        }
        byte[] sourceData = read(source);
        byte[] destinationData = generateKey(key,sourceData.length-1);
        for (int si = 0;si<sourceData.length-1;si++)
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
        	throw new DecodeException(ioException.toString());
        }
        
    }


}
