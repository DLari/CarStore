package ru.reksoft.interns.carstore.service;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class imageService {

    public int getById() throws IOException {
        File file = new File("C://Users//dlarin//images//3audiq8.jpg");
        BufferedImage image = ImageIO.read(file);
        return image.getWidth();
    }

}
