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


    @GetMapping(value = "/{id}")
    public @ResponseBody byte[] getImage(@PathVariable Integer id) throws IOException {
        return imageService.getImage(id);
    }
}
