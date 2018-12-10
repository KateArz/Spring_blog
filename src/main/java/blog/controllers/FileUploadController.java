package blog.controllers;

import blog.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
public class FileUploadController {

    @Autowired
    StorageService storageService;

    @RequestMapping(value="fileupload", produces="application/json")
    @ResponseBody
    public HashMap<String,Object> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try(InputStream fileStream = file.getInputStream()) {

            String location = storageService.store(fileStream,file.getOriginalFilename());
            HashMap<String,Object> hashMap = new HashMap<>(1);

            hashMap.put("location", location);
            return hashMap;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
