package com.example.thmd4.service.impl;

import com.example.thmd4.model.Image;
import com.example.thmd4.repository.ImageRepository;
import com.example.thmd4.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findOne(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);

    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }
}
