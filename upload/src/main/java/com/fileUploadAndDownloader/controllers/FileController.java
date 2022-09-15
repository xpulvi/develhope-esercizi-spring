package com.fileUploadAndDownloader.controllers;

import com.fileUploadAndDownloader.services.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    //(@RequestParam MultipartFile file[]) pui anche caricare file multipli. un array di file
    public List <String> download(@RequestParam MultipartFile[] files) throws Exception{
        //lista nomi files
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file: files) {
        String singleUpLoadedFileName = fileStorageService.upload(file);
        fileNames.add(singleUpLoadedFileName);
        }
      return fileNames;

    }

    @GetMapping("/download")
    public @ResponseBody byte[] upload(@RequestParam String fileName, HttpServletResponse response) throws Exception{
        System.out.println("downloading " + fileName);
        String exstencion = FilenameUtils.getExtension(fileName);
        switch (exstencion){
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
        return fileStorageService.dounload(fileName);

    }

}
