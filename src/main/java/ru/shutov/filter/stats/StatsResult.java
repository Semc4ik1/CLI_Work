package ru.shutov.filter.stats;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatsResult {
    private int writtenElements = 0;
    private Double maxValue = Double.MIN_VALUE;
    private Double minValue = Double.MAX_VALUE;
    private Double sum = 0.0;
    private Double avg = 0.0;
}
