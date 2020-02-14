package ru.reksoft.interns.carstore.service;

import java.io.File;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Service
public class ImageService {

    @Value("${files.dir}")
    String pathToFiles;

    public byte[] getImage(Integer id) throws IOException {

//        String pathDefault = "C:\\Users\\dlarin\\images\\default.jpg";
        String pathDefault = "C:\\Users\\dlarin\\IdeaProjects2\\CarStore\\CarStore\\src\\main\\resources\\image\\default.jpg";
      //  String pathToFile = "C:\\Users\\dlarin\\images\\";
        String pathToModel = pathToFiles + id + ".jpg";
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

    public void uploadImage (String modelId, MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(pathToFiles + modelId+".jpg" )));
                stream.write(bytes);
                stream.close();

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

}

