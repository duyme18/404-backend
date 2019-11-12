package com.hotel.demo.controller;

import com.hotel.demo.model.FileForm;
import com.hotel.demo.model.Home;
import com.hotel.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/auth/file")
public class ApiFileController {
    @Autowired
    private HomeService homeService;

    @Autowired
    Environment env;

    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadFile(@ModelAttribute FileForm fileForm, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file.upload-dir").toString();

        try {
            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<Home> home = homeService.findById(id);
        home.get().setFile(fileName);
        homeService.save(home.get());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
