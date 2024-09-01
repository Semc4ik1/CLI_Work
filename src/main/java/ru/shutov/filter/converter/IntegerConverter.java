package ru.shutov.filter.converter;

public class IntegerConverter implements Converter<Integer> {
    @Override
    public Integer convert(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ignored) {
            return null;
        }
    }
}
