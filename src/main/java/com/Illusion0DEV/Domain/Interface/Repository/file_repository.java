package com.Illusion0DEV.Domain.Interface.Repository;

import jakarta.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Repository
public class file_repository {

    @Autowired
    private ServletContext servlet_context;

    List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif","image/jpg");

    public String save_image(MultipartFile file) throws Exception{

        if(!contentTypes.contains(file.getContentType())){
            throw new Exception("File isn't an image");
        }

        String folder = servlet_context.getRealPath("/") +"/Upload/image/";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder +file.getOriginalFilename());
        Files.write(path,bytes);
        return path.toString();
    }

    public String save_message_image(MultipartFile file,String pathStr) throws Exception{
        if(!contentTypes.contains(file.getContentType())){
            throw new Exception("File isn't an image");
        }

        String filePath = servlet_context.getRealPath("/") + pathStr;
        byte[] bytes = file.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path,bytes);
        return path.toString();
    }
}
