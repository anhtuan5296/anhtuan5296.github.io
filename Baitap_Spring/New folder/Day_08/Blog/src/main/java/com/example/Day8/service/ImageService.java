package com.example.Day8.service;

import com.example.Day8.entity.Image;
import com.example.Day8.entity.User;
import com.example.Day8.repository.ImageRepository;
import com.example.Day8.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    
    public ImageService(ImageRepository imageRepository, UserRepository userRepository){
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    public List<Image> getFileOfCurrentUser(){
        Integer userId = 1;
        return imageRepository.findByUser_IdOrderByCreatedAtDesc(userId);
    }

    public Image uploadFile( MultipartFile file) throws IOException {
        Integer userId = 1;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

        Image image = new Image();
        image.setType(file.getContentType());
        image.setData(file.getBytes());
        image.setUser(user);
        imageRepository.save(image);

        return image;
    }

    public Image getFileById(Integer id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id " + id));
    }

    public void deleteFile(Integer id) {
        Image file = getFileById(id);
        imageRepository.delete(file);
    }
}
