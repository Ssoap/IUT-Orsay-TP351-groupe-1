package edu.iut.cipher.decoder;

import edu.iut.exceptions.DecodeException;

import java.io.File;

public interface FileDecoder {
    public void decode(File source, File destination, String key) throws DecodeException;
}
