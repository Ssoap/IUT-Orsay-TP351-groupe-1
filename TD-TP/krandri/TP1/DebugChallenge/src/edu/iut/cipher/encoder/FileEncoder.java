package edu.iut.cipher.encoder;
import edu.iut.exceptions.EncodeException;

import java.io.File;

public interface FileEncoder {
    public void encode(File source, File destination, String key) throws EncodeException;
}
