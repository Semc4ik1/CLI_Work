package ru.shutov.filter.stats;

public abstract class Stats<T> {
    protected final StatsResult result = new StatsResult();

    public abstract void update(T value);

    public abstract String getFullStats();

    public abstract String getShortStats();
}
