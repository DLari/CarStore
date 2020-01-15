package ru.reksoft.interns.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reksoft.interns.carstore.service.imageService;

import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class imageController {

    @Autowired
    private imageService imageService;

    @GetMapping("")
    @ResponseBody
    public int getById (
           // @PathVariable("id")  Integer id
    ){
        try {
            int width = imageService.getById();
            return width;
        }
        catch (IOException e){
            e.getMessage();
        }
        return 0;
    }
}
