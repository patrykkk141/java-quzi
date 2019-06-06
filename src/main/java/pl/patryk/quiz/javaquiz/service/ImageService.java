package pl.patryk.quiz.javaquiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.patryk.quiz.javaquiz.exception.FileException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private static final String API_IMAGE_URL = "http://localhost:8080/image/";
    private final String folder = ImageService.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/images/";
    private final List<String> imagesExtensions = new ArrayList<>(Arrays.asList(".png", ".jpg", ".jpeg", ".gif"));

    /**
     * Return image by img name
     */
    public File getFileByName(String name) {
        File f = new File(folder + name);
        if (f.exists()) return f;
        return null;
    }

    /**
     * Save image and return path to file
     */
    public String saveImage(MultipartFile file) throws IOException, FileException {
        if (file != null && !file.isEmpty()) {
            String ext = getFileExtension(file.getOriginalFilename());
            if (isImage(ext)) {
                String name = UUID.randomUUID().toString().concat(ext);
                File f = new File(folder + name);
                f.createNewFile();
                file.transferTo(f);
                return API_IMAGE_URL + name;
            }
            throw new FileException("File is not an image!");
        }
        throw new FileException("File is empty!");
    }

    /**
     * Get file extension*/
    private String getFileExtension(String s) {
        if (s.lastIndexOf(".") > 0)
            return s.substring(s.lastIndexOf("."));
        else return null;
    }

    /**
     * Check if image extension exists in extensions list*/
    private boolean isImage(String s) {
        return imagesExtensions.contains(s);
    }
}
