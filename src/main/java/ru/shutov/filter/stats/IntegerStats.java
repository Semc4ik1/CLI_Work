package ru.shutov.filter.stats;

public class IntegerStats extends Stats<Integer> {

    @Override
    public String getShortStats() {
        return "Written integers elements: " + result.getWrittenElements();
    }

    @Override
    public String getFullStats() {
        int max = result.getMaxValue().intValue();
        int min = result.getMinValue().intValue();
        int sum = result.getSum().intValue();
        return """
                Written integers elements: %s
                Max value: %s
                Min value: %s
                Sum: %s
                Avg: %s
                """.formatted(result.getWrittenElements(), max, min, sum, result.getAvg());
    }

    @Override
    public void update(Integer value) {
        result.setWrittenElements(result.getWrittenElements() + 1);
        result.setSum(result.getSum() + value);

        Double maxValue = result.getMaxValue();
        Double minValue = result.getMinValue();

        if (maxValue < value) {
            result.setMaxValue((double) value);
        }

        if (minValue > value) {
            result.setMinValue((double) value);
        }

        result.setAvg(result.getSum() / result.getWrittenElements());
    }
}
