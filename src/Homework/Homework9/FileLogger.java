package Homework9;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        if (configuration.getLoggingLevel().isLevelVisible(LoggingLevel.DEBUG)) {
            log(LoggingLevel.DEBUG, message);
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        if (configuration.getLoggingLevel().isLevelVisible(LoggingLevel.INFO)) {
            log(LoggingLevel.INFO, message);
        }
    }

    private void log(LoggingLevel level, String message) throws FileMaxSizeReachedException {
        try {
            FileWriter writer = new FileWriter(configuration.getFilePath(), true);
            String logEntry = "[" + getCurrentTime() + "]" + "[" + level.name() + "] " + "Повідомлення: " + message + "\n";
            writer.write(logEntry);
            writer.close();

            checkFileSize();
        } catch (IOException e) {
            // Обробка винятків запису до файлу
            e.printStackTrace();
        }
    }

    private String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    }

    private void checkFileSize() throws FileMaxSizeReachedException {
        long fileSize = configuration.getFile().length();
        if (fileSize >= configuration.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(
                    "Максимальний розмір файлу перевищено",
                    configuration.getMaxFileSize(),
                    fileSize,
                    configuration.getFilePath());
        }
    }
}