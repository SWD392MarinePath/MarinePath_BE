package com.example.marinepath.service;


import com.example.marinepath.entity.Image;
import com.example.marinepath.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void saveImage(String url) {
        Image image = new Image();
        image.setUrl(url);
        imageRepository.save(image);
    }



}