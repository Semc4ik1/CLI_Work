package ru.shutov.filter.stats;

public class StringStats extends Stats<String> {

    @Override
    public String getShortStats() {
        return "Written string elements: " + result.getWrittenElements();
    }

    @Override
    public String getFullStats() {
        return """
                Written string elements: %s
                Max length: %s
                Min length: %s
                """.formatted(result.getWrittenElements(), result.getMaxValue().intValue(),
                result.getMinValue().intValue());
    }

    @Override
    public void update(String value) {
        result.setWrittenElements(result.getWrittenElements() + 1);

        Double minValue = result.getMinValue();
        Double maxValue = result.getMaxValue();

        if (maxValue < value.length()) {
            result.setMaxValue((double) value.length());
        }

        if (minValue > value.length()) {
            result.setMinValue((double) value.length());
        }
    }
}
