package com.fileUploadAndDownloader.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    //riocrdati di metere il $ nella stringa value.
    @Value("${fileRepositoryFolder}")
    private String fileRepositoryFolder;

    /**
     *
     * @param file File from upload controller
     * @return New file name with extension
     * @throws IOException if filder is writable
     */
    public String upload(MultipartFile file) throws IOException {
        String exstencion = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString();
        String complitFileName = newFileName + "." + exstencion;
        //verification in Repository Folder
        File finalFolder = new File(fileRepositoryFolder);
        if (!finalFolder.exists()) throw new IOException("Final folder dies not exists");
        if (!finalFolder.isDirectory()) throw new IOException("Final folder is not a directory");

        File finalDestination = new File(fileRepositoryFolder + "\\" + complitFileName);
        if (finalDestination.exists()) throw new IOException("File conflict");


        file.transferTo(finalDestination);
        return complitFileName;

    }

    public byte[] dounload(String fileName) throws IOException{
        File finalFromRepositoryF = new File(fileRepositoryFolder + fileName);
        if (!finalFromRepositoryF.exists()) throw new IOException("File dot exist");
        return IOUtils.toByteArray(new FileInputStream(finalFromRepositoryF));
    }

}
