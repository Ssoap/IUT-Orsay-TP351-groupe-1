package edu.iut.cipher.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileManager {
	public FileManager() {
		
	}
	protected byte[] generateKey(String sourceKey,int size)
    {
        byte[] cryptKey = new byte[size];
        byte[] byteKey = sourceKey.getBytes();
        int sourceKeyOffset = 0;
        for (int si = 0;si<size;si++)
        {
        	if (sourceKeyOffset >= byteKey.length)
            {
                sourceKeyOffset=0;
            }
            cryptKey[si] = byteKey[sourceKeyOffset];
            sourceKeyOffset++;
        }
        return cryptKey;
    }
    
    protected byte[] read(File source)
    {        
        byte[] fileData = new byte[(int)source.length()];
        try {
          InputStream input = null;
          try {
            int totalBytesRead = 0;
            input = new BufferedInputStream(new FileInputStream(source));
            while(totalBytesRead < fileData.length){
              int bytesRemaining = fileData.length - totalBytesRead;
              //input.read() returns -1, 0, or more :
              int bytesRead = input.read(fileData, totalBytesRead, bytesRemaining); 
              if (bytesRead > 0){
                totalBytesRead = totalBytesRead + bytesRead;
              }
            }
          }
          finally {
            input.close();
          }
        }
        catch (IOException ex) {
            return null;
        }
        return fileData;
    }
    
    protected void write(byte[] data,File destination) throws IOException
    {
        OutputStream output = null;
        output = new BufferedOutputStream(new FileOutputStream(destination));
    	output.write(data);
    	output.close();

    }
}
