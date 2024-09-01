package ru.shutov.filter.stats;

public class DoubleStats extends Stats<Double> {

    @Override
    public String getShortStats() {
        return "Written double elements: " + result.getWrittenElements();
    }

    @Override
    public String getFullStats() {
        return """
                Written double elements: %s
                Max value: %s
                Min value: %s
                Sum: %s
                Avg: %s
                """.formatted(result.getWrittenElements(), result.getMaxValue(),
                result.getMinValue(), result.getSum(), result.getAvg());
    }

    @Override
    public void update(Double value) {
        result.setWrittenElements(result.getWrittenElements() + 1);
        result.setSum(result.getSum() + value);

        Double maxValue = result.getMaxValue();
        Double minValue = result.getMinValue();

        if (maxValue < value) {
            result.setMaxValue(value);
        }

        if (minValue > value) {
            result.setMinValue(value);
        }

        result.setAvg(result.getSum() / result.getWrittenElements());
    }
}
