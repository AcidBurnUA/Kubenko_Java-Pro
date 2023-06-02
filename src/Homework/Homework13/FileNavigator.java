package Homework13;
import java.util.*;
public class FileNavigator {
    private Map<String, List<FileData>> filesByPath;

    public FileNavigator() {
        filesByPath = new HashMap<>();
    }

    public void add(FileData file) {
        String path = file.getPath();
        if (!filesByPath.containsKey(path)) {
            filesByPath.put(path, new ArrayList<>());
        }
        filesByPath.get(path).add(file);
    }

    public List<FileData> find(String path) {
        return filesByPath.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(int maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> files : filesByPath.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    filteredFiles.add(file);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        filesByPath.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> files : filesByPath.values()) {
            allFiles.addAll(files);
        }
        allFiles.sort(Comparator.comparingInt(FileData::getSize));
        return allFiles;
    }

    public void add(FileData file, String keyPath) {
        String fileDataPath = file.getPath();
        if (fileDataPath.equals(keyPath)) {
            add(file);
        } else {
            System.out.println("Шлях-ключ і шлях до файлу не співпадають");
        }
    }
}
