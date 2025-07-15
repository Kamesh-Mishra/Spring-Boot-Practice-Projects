package com.file.demo.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FileUploadController {
	
    private FileUploadService uploadService;

//    https://www.youtube.com/watch?v=SYMGDLwpM7g&list=PLi9GDhYIFlDiqDpVTS-dSiyDUuwupVYD4&index=5
    
    @PostMapping("/upload")
    public FileUploadResponse uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        FileUpload attachment = null;
        String downloadUrl = "";
        attachment = uploadService.saveFile(file);
        downloadUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();
        return new FileUploadResponse(attachment.getFileName(), downloadUrl, file.getContentType(), file.getSize());

    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> download(@PathVariable("fileId")String fileId) throws Exception {
        FileUpload fileUpload = null;
        fileUpload = uploadService.downloadFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileUpload.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileUpload; filename=\""+ fileUpload.getFileName()
                        +"\"").body(new ByteArrayResource(fileUpload.getData()));
    }

}