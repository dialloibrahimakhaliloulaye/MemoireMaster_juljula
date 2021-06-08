package com.juljula.web;

import com.juljula.dao.ProductRepository;
import com.juljula.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class CatalogueController {
    private ProductRepository productRepository;

    public CatalogueController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "photoProduct/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/IdeaProjects/Produits/"+p.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        p.setPhotoName(id+".jpg");
        Files.write(Paths.get(System.getProperty("user.home")+"/IdeaProjects/Produits/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);
    }
}
