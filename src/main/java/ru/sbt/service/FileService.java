package ru.sbt.service;

import org.springframework.stereotype.Service;
import ru.sbt.repository.FileRepository;

@Service
public class FileService {
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void addFile(String filename, byte[] file) {
        this.fileRepository.addFile(filename, file);
    }

    public byte[] getFile(String filename) throws Exception {
        return this.fileRepository.getFile(filename);
    }
}
