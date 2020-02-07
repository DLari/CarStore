package ru.reksoft.interns.carstore.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.service.ImageService;

import java.io.*;

@RestController
@RequestMapping("/images")
public class ImageController  {

    @Autowired
    private ImageService imageService;


    @GetMapping(value = "")
    public @ResponseBody byte[] getImage() throws IOException {

        File image = new File("C:\\Users\\dlarin\\images\\3audiq8.jpg");
        InputStream in = new FileInputStream (image);
        return IOUtils.toByteArray(in);
    }
}
