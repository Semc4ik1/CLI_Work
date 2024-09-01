package ru.shutov.filter.io;

import java.util.List;

public class ConsolePrinter implements Printer {
    @Override
    public void print(List<String> message) {
        message.forEach(System.out::println);
    }
}
