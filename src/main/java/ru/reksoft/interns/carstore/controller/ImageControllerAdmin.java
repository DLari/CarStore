package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.reksoft.interns.carstore.service.ImageService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/admin/images")
public class ImageControllerAdmin {

    @Autowired
    private ImageService imageService;



    @PostMapping("")
    public void create(
            //@RequestParam("file")
            @RequestBody MultipartFile file) throws IOException {
             imageService.uploadImage(file);
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload( @RequestParam("modelId") String modelId,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\dlarin\\images\\"+modelId+".jpg" )));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили " +  " в "  + "-uploaded !";
            } catch (Exception e) {
                return "Вам не удалось загрузить "  + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить "  + " потому что файл пустой.";
        }
    }

}
