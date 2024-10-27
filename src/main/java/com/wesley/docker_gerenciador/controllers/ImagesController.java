package com.wesley.docker_gerenciador.controllers;

import com.github.dockerjava.api.model.Image;
import com.wesley.docker_gerenciador.service.DockerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    private final DockerService dokcerService;

    public ImagesController(DockerService dockerService) {
        this.dokcerService = dockerService;
    }

    @GetMapping("")
    public List<Image> listImages() {
        return dokcerService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> listImages(@RequestParam(required = false, defaultValue = "image-") String filterName) {
        return dokcerService.filterImages(filterName);
    }
}
