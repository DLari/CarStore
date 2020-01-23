//package ru.reksoft.interns.carstore.controller;
//
//
//
//import org.apache.logging.log4j.core.util.IOUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.support.ServletContextResource;
//import ru.reksoft.interns.carstore.service.imageService;
//
//
//import javax.servlet.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
//@RestController
//@RequestMapping("/images")
//public class imageController implements Servlet {
//
//    @Autowired
//    private imageService imageService;
//
//    @RequestMapping(value = "/image-response-entity", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> getImageAsResponseEntity() {
//        HttpHeaders headers = new HttpHeaders();
//        InputStream in = getServletConfig().getServletContext().getResourceAsStream("/WEB-INF/images/image-example.jpg");
//        byte[]media = IOUtils.toByteArray(in);
//        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
//        return responseEntity;
//    }
//}
