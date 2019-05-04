package pl.patryk.quiz.javaquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.patryk.quiz.javaquiz.exception.FileException;
import pl.patryk.quiz.javaquiz.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ImagesController {

    private final FileService fileService;

    @Autowired
    public ImagesController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/api/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveImage(file);
            return new ResponseEntity<>("Image saved", HttpStatus.CREATED);
        } catch (IOException | FileException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Could not save image !", HttpStatus.OK);
        }
    }

    @GetMapping("/api/image/{imageName}")
    public ResponseEntity<?> downloadImage(@PathVariable("imageName") String imgName) throws IOException {
        File file = fileService.getFileByName(imgName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(Files.probeContentType(file.toPath())));
        System.out.println("Media type: " + headers.getContentType());
        try {
            byte[] arr = Files.readAllBytes(file.toPath());
            return new ResponseEntity<>(arr, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Could not load file!", HttpStatus.OK);
        }
    }
}
