package pl.patryk.quiz.javaquiz.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImageDto {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
