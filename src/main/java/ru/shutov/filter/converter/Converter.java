package ru.shutov.filter.converter;

public interface Converter<T> {
    T convert(String str);
}
