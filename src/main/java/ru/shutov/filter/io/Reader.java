package ru.shutov.filter.io;

import java.util.List;

public interface Reader {
    List<String> read(String path);
}
