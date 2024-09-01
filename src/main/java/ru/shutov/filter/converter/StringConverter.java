package ru.shutov.filter.converter;

public class StringConverter implements Converter<String> {
    @Override
    public String convert(String str) {
        return str;
    }
}
