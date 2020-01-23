package ru.reksoft.interns.carstore.service;

import org.apache.logging.log4j.core.util.IOUtils;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class imageService {

    public byte[] getImage() throws IOException {

        byte[] imageInByte;
        BufferedImage bImage = ImageIO.read(new File("C://Users//dlarin//images//3audiq8.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        bos.flush();
        imageInByte = bos.toByteArray();
        bos.close();
        return imageInByte;
    }
}

