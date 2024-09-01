package ru.shutov.filter.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class FilePrinter implements Printer {
    private String directory;
    private String path;
    private boolean append;

    @Override
    public void print(List<String> message) {
        try {
            if (message.isEmpty()) {
                return;
            }

            if (directory != null) {
                Files.createDirectories(Path.of(directory));
            }

            if (append) {
                Files.write(Path.of(directory + path), message, StandardOpenOption.CREATE);
            } else {
                Files.write(Path.of(directory + path), message, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
