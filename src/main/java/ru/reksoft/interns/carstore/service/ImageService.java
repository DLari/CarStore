package ru.reksoft.interns.carstore.service;

import java.io.File;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Service
public class ImageService {

    public byte[] getImage(Integer id) throws IOException {

        String pathDefault = "C:\\Users\\dlarin\\images\\default.jpg";
        String pathToFile = "C:\\Users\\dlarin\\images\\";
        String pathToModel = pathToFile + id + ".jpg";
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

    public void uploadImage (MultipartFile file) throws IOException {

        String pathToFile = "C:\\Users\\dlarin\\images\\";
        //InputStream inputStream = file.getInputStream();
        byte[] bytes = file.getBytes();
        try (FileOutputStream fos = new FileOutputStream(pathToFile)){
            fos.write(bytes);
        }
    }
}

