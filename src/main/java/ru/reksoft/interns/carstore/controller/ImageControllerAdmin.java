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

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody void handleFileUpload( @RequestParam("modelId") String modelId,
            @RequestParam("file") MultipartFile file) throws IOException {

        imageService.uploadImage(modelId,file);


    }

}
