package ru.sbt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.sbt.service.FileService;

@RestController
@RequestMapping("/")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(
        value = "/getFile",
        produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public byte[] getFile(@RequestParam String filename) throws Exception {
        return this.fileService.getFile(filename);
    }

    @PostMapping(value="/file")
    public void addFile(@RequestParam String filename, @RequestBody byte[] file) {
        this.fileService.addFile(filename, file);
    }
}
