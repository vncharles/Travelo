package com.fit.Travelo.controller;

import com.fit.Travelo.service.impl.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/image/")
public class ImageController {

    @RequestMapping("/{uriImage}")
    public ResponseEntity<byte[]> getImage(@PathVariable("uriImage")String uriImage) throws IOException {
        byte[] image = ImageService.getImage("images/" + uriImage);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

}
