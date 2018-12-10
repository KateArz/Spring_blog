package blog.services;

import com.google.common.io.Files;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public String store(InputStream stream, String fileName) throws IOException {
        String fileExt = Files.getFileExtension(fileName);
        String newFileName = Files.getNameWithoutExtension(fileName);
        Date date = new Date();
        Long timestamp = date.getTime()/1000;
        newFileName = newFileName + "_" + timestamp.toString() + "." + fileExt;
        Path outFilePath = Paths.get("target/classes/public/img/uploaded/" , newFileName);
        File outFile = outFilePath.toFile();
        System.out.println(outFile.getAbsolutePath());
        FileOutputStream out = new FileOutputStream(outFile);
        byte[] buffer = new byte[stream.available()];
        // считываем буфер
        stream.read(buffer, 0, buffer.length);
        // записываем из буфера в файл
        out.write(buffer, 0, buffer.length);
        return newFileName;
    }
}
