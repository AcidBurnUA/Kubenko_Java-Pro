package Homework9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) throws IOException {
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("FILE:")) {
                    String file = line.substring(line.indexOf(":") + 1).trim();
                    configuration.setFilePath(file);
                } else if (line.startsWith("LEVEL:")) {
                    String level = line.substring(line.indexOf(":") + 1).trim();
                    configuration.setLogLevel(level);
                } else if (line.startsWith("MAX-SIZE:")) {
                    String maxSize = line.substring(line.indexOf(":") + 1).trim();
                    configuration.setMaxFileSize(Long.parseLong(maxSize));
                } else if (line.startsWith("FORMAT:")) {
                    String format = line.substring(line.indexOf(":") + 1).trim();
                    configuration.setLogFormat(format);
                }
            }
        }

        return configuration;
    }
}



