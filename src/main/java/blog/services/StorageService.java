package blog.services;


import java.io.IOException;
import java.io.InputStream;

public interface StorageService {

   String store(InputStream stream, String fileName) throws IOException;
}
