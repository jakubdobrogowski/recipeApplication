package guru.springframework.spring5recipeapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImage(Long aLong, MultipartFile multipartFile);

}
