package ru.shutov.filter.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader implements Reader {
    @Override
    public List<String> read(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
