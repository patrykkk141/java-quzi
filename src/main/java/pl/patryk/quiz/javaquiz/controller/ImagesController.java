package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.patryk.quiz.javaquiz.exception.FileException;
import pl.patryk.quiz.javaquiz.exception.NotFoundException;
import pl.patryk.quiz.javaquiz.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ImagesController {

    private final ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.saveImage(file);
            return new ResponseEntity<>("Image saved", HttpStatus.CREATED);
        } catch (IOException | FileException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Could not save image !", HttpStatus.OK);
        }
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<?> downloadImage(@PathVariable("imageName") String imgName) throws Exception {
        File file = imageService.getFileByName(imgName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(Files.probeContentType(file.toPath())));
        System.out.println("Media type: " + headers.getContentType());
        try {
            byte[] arr = Files.readAllBytes(file.toPath());
            return new ResponseEntity<>(arr, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NotFoundException("Image not found!");
        }
    }
}
