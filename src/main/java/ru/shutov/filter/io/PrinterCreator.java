package ru.shutov.filter.io;

public class PrinterCreator {
    private PrinterCreator() {}

    public static Printer create(String directory, String filename, boolean append) {
        return new FilePrinter(directory, filename, append);
    }
}
