package ru.shutov.filter.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParseParameters {
    private List<String> inputFiles;
    private String outputPath = "";
    private String prefix = "";
    private Boolean appendEnabled = false;
    private StatType statType = StatType.SHORT;
}
