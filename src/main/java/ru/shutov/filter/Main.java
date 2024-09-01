package ru.shutov.filter;

import org.apache.commons.cli.ParseException;
import ru.shutov.filter.converter.DoubleConverter;
import ru.shutov.filter.converter.IntegerConverter;
import ru.shutov.filter.converter.StringConverter;
import ru.shutov.filter.filter.Filter;
import ru.shutov.filter.io.*;
import ru.shutov.filter.options.ParseParameters;
import ru.shutov.filter.options.Parser;
import ru.shutov.filter.options.StatType;
import ru.shutov.filter.stats.DoubleStats;
import ru.shutov.filter.stats.IntegerStats;
import ru.shutov.filter.stats.StringStats;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Reader READER = new FileReader();
    private static final Printer CONSOLE = new ConsolePrinter();

    public static void main(String[] args) {
        try {
            ParseParameters parameters = Parser.parse(args);

            List<String> list = new ArrayList<>();
            parameters.getInputFiles().forEach(val -> {
                List<String> read = READER.read(val);
                list.addAll(read);
            });

            StatType statType = parameters.getStatType();

            Map<String, Filter<?>> filters = new LinkedHashMap<>();
            filters.put("integers", new Filter<>(new IntegerConverter(), new IntegerStats(), CONSOLE));
            filters.put("floats", new Filter<>(new DoubleConverter(), new DoubleStats(), CONSOLE));
            filters.put("strings", new Filter<>(new StringConverter(), new StringStats(), CONSOLE));

            for (Map.Entry<String, Filter<?>> entry : filters.entrySet()) {
                String type = entry.getKey();
                Filter<?> filter = entry.getValue();
                List<?> converted = filter.execute(list, statType);
                Printer printer = PrinterCreator.create(
                        parameters.getOutputPath(),
                        parameters.getPrefix() + type + ".txt",
                        parameters.getAppendEnabled()
                );
                printer.print(toStringList(converted));
            }

        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<String> toStringList(List<?> objects) {
        return objects.stream().map(Object::toString).toList();
    }
}
