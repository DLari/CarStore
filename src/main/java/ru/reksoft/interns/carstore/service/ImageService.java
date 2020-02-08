package ru.reksoft.interns.carstore.service;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

@Service
public class ImageService {

    public byte[] getImage(String modelName) throws IOException {

        String pathDefault = "C:\\Users\\dlarin\\images\\default.jpg";
        String pathToFile = "C:\\Users\\dlarin\\images\\";
        String pathToModel = pathToFile + modelName + ".jpg";
        File imageModel = new File(pathToModel);
       boolean f = imageModel.exists();
        InputStream in;
       if (f)
            in = new FileInputStream (imageModel);
       else {
           File imageDefault = new File(pathDefault);
           in = new FileInputStream(imageDefault);
       }
        return IOUtils.toByteArray(in);
    }
}

