package com.th3.openclass.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.th3.openclass.model.FileInfo;
import com.th3.openclass.model.ResponseMessage;
import com.th3.openclass.model.Student;
import com.th3.openclass.service.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import static com.th3.openclass.constants.ResourcePath.*;

@Controller(V1 + AUTH + STUDENT + "/upload")
@CrossOrigin("*")
public class FileController {

    @Autowired
    FileStorageService storageService;

    @PostMapping(V1 + AUTH + STUDENT + "/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);

            // TODO UUID validation for a new file.
            FileInfo fileInfo = new FileInfo(file.getOriginalFilename(), file.getName());

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping(V1 + AUTH + STUDENT + "/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @DeleteMapping(V1 + AUTH + STUDENT + "/files")
    public ResponseEntity<ResponseMessage> deleteFiles()
    {
        String message = "all files were deleted";
        storageService.deleteAll();
        storageService.init();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }

    @GetMapping(V1 + AUTH + STUDENT + "/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
