package ru.sbt.repository;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FileRepository {
    private final ConcurrentHashMap<String, byte[]> repo;

    public FileRepository() {
        this.repo = new ConcurrentHashMap<>();
    }

    public void addFile(String filename, byte[] file) {
        repo.put(filename, file);
    }

    public byte[] getFile(String filename) throws Exception {
        if (!repo.containsKey(filename)) {
            throw new Exception("File " + filename + " does not exist!");
        }
        return repo.get(filename);
    }
}
