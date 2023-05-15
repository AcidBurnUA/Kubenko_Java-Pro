package Homework9;
public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean isLevelVisible(LoggingLevel level) {
        return this.ordinal() >= level.ordinal();
    }
}

