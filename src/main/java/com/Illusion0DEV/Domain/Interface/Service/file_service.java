package com.Illusion0DEV.Domain.Interface.Service;

import com.Illusion0DEV.Domain.Interface.Repository.file_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class file_service {

    @Autowired
    file_repository file_repository;

    public String save_image(MultipartFile file) throws Exception {
        return file_repository.save_image(file);
    }

    public String save_message_image(MultipartFile file, String pathStr) throws Exception {
        return file_repository.save_message_image(file, pathStr);
    }

}
