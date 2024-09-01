package ru.shutov.filter.filter;

import ru.shutov.filter.converter.Converter;
import ru.shutov.filter.io.Printer;
import ru.shutov.filter.options.StatType;
import ru.shutov.filter.stats.Stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Filter<T> {
    private final Converter<T> converter;
    private final Stats<T> stats;
    private final Printer printer;

    public Filter(Converter<T> converter, Stats<T> stats, Printer printer) {
        this.converter = converter;
        this.stats = stats;
        this.printer = printer;
    }

    public List<T> convert(List<String> list, StatType statType) {
        List<T> converted = new ArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            T val = converter.convert(iterator.next());

            if (val == null) {
                continue;
            }

            stats.update(val);
            converted.add(val);
            iterator.remove();
        }

        printStats(statType);
        return converted;
    }

    private void printStats(StatType statType) {
        switch (statType) {
            case FULL -> printer.print(Collections.singletonList(stats.getFullStats()));
            case SHORT -> printer.print(Collections.singletonList(stats.getShortStats()));
        }
    }
}
