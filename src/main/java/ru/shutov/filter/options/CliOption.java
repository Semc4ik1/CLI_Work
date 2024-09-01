package ru.shutov.filter.options;

public enum CliOption {
    INPUT("i", "Input files"),
    OUTPUT("o", "Output path"),
    PREFIX("p", "File names prefix"),
    APPEND("a", "Enable appending to existing files"),
    SHORT_STAT("s", "Short stats"),
    FULL_STAT("f", "Full stats");

    private final String name;
    private final String description;

    CliOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
