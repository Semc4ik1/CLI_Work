package ru.shutov.filter.options;

import org.apache.commons.cli.*;

import java.util.List;

public class Parser {
    private static CommandLine cmd;
    private static ParseParameters params;

    private Parser() {
        throw new UnsupportedOperationException("Cannot instantiate util class");
    }

    public static ParseParameters parse(String[] args) throws ParseException {
        if (params != null) {
            return params;
        }

        initializeCmd(args);
        return params;
    }

    private static void initializeCmd(String[] args) throws ParseException {
        Options options = new Options();

        Option inputOption = Option.builder()
                .option(CliOption.INPUT.getName())
                .desc(CliOption.INPUT.getDescription())
                .hasArgs()
                .numberOfArgs(Option.UNLIMITED_VALUES)
                .required()
                .build();
        options.addOption(inputOption);

        Option outputOption = Option.builder()
                .option(CliOption.OUTPUT.getName())
                .desc(CliOption.OUTPUT.getDescription())
                .hasArg()
                .numberOfArgs(1)
                .build();
        options.addOption(outputOption);

        Option prefixOption = Option.builder()
                .option(CliOption.PREFIX.getName())
                .desc(CliOption.PREFIX.getDescription())
                .hasArg()
                .numberOfArgs(1)
                .build();
        options.addOption(prefixOption);

        Option appendOption = Option.builder()
                .option(CliOption.APPEND.getName())
                .desc(CliOption.APPEND.getDescription())
                .build();
        options.addOption(appendOption);

        OptionGroup statOptionGroup = new OptionGroup();
        Option fullStatOption = Option.builder()
                .option(CliOption.FULL_STAT.getName())
                .desc(CliOption.FULL_STAT.getDescription())
                .build();
        Option shortStatOption = Option.builder()
                .option(CliOption.SHORT_STAT.getName())
                .desc(CliOption.SHORT_STAT.getDescription())
                .build();

        statOptionGroup.setRequired(false);
        statOptionGroup.addOption(fullStatOption);
        statOptionGroup.addOption(shortStatOption);
        options.addOptionGroup(statOptionGroup);

        CommandLineParser cmdParser = new DefaultParser();
        cmd = cmdParser.parse(options, args);

        collectParams();
    }

    private static void collectParams() {
        if (cmd == null) {
            throw new IllegalStateException();
        }

        params = new ParseParameters();

        String[] inputFiles = cmd.getOptionValues(CliOption.INPUT.getName());
        params.setInputFiles(List.of(inputFiles));

        if (cmd.hasOption(CliOption.APPEND.getName())) {
            params.setAppendEnabled(true);
        }

        if (cmd.hasOption(CliOption.OUTPUT.getName())) {
            String outputPath = cmd.getOptionValue(CliOption.OUTPUT.getName());
            params.setOutputPath(outputPath + "/");
        }

        if (cmd.hasOption(CliOption.PREFIX.getName())) {
            String prefix = cmd.getOptionValue(CliOption.PREFIX.getName());
            params.setPrefix(prefix);
        }

        if (cmd.hasOption(CliOption.FULL_STAT.getName())) {
            params.setStatType(StatType.FULL);
        }
    }
}
