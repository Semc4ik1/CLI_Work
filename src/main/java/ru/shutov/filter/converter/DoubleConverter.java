package ru.shutov.filter.converter;

public class DoubleConverter implements Converter<Double> {
    @Override
    public Double convert(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
