package pl.patryk.quiz.javaquiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.patryk.quiz.javaquiz.exception.FileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    // TODO: 03.05.2019 Zmienic sciezke przed wrzuceniem na serwer
    private static final String PATH = "C:\\Users\\Patryk\\Desktop\\files\\";
    private static final String API_IMAGE_URL = "http://localhost:8080/api/image/";
    private final List<String> imagesExtensions = new ArrayList<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif"));

    public File getFileByName(String name) throws FileNotFoundException {
        File file = new File(PATH + name);
        if (file.exists() && file.length() > 1024) return file;
        throw new FileNotFoundException("File not found!");
    }


    /**
     * Save image and return path to file
     */
    public String saveImage(MultipartFile file) throws IOException, FileException {
        if (!file.isEmpty()) {
            String ext = getFileExtension(file.getOriginalFilename());
            if (isImage(ext)) {
                String name = UUID.randomUUID().toString().concat(ext);
                String imgPath = PATH + name;
                File f = new File(imgPath);

                f.createNewFile();
                file.transferTo(f);
                return API_IMAGE_URL+name;
            }
            throw new FileException("File is not an image!");
        }
        throw new FileException("File is empty!");
    }

    private String getFileExtension(String s) {
        if (s.lastIndexOf(".") > 0)
            return s.substring(s.lastIndexOf("."));
        else return null;
    }

    private boolean isImage(String s) {
        return imagesExtensions.contains(s);
    }
}
