package com.example.Day8.rest;

import com.example.Day8.entity.Image;
import com.example.Day8.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class ImageResource {
    private final ImageService imageService;

    public ImageResource(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/admin/images")
        public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
            return ResponseEntity.ok(imageService.uploadFile(file));
        }
    // 2. Xem file
    @GetMapping("/{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        Image image = imageService.getFileById(id);
        // Code logic
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData()); // 200
    }

    // 3. Xoa file
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        imageService.deleteFile(id);
        // Code logic
        return ResponseEntity.noContent().build(); // 204
    }
}
