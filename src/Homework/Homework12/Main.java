package Homework12;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Приклад виклику методів
        List<String> wordList = new ArrayList<>();
        wordList.add("bird");
        wordList.add("cat");
        wordList.add("dog");
        wordList.add("bird");
        wordList.add("cat");

        String word = "bird";
        int occurrenceCount = countOccurrence(wordList, word);
        System.out.println("The word \"" + word + "\" occurs " + occurrenceCount + " times.");

        Integer[] array = {1, 2, 3};
        List<Integer> list = toList(array);
        System.out.println(list);

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(2);
        numberList.add(1);

        List<Integer> uniqueNumbers = findUnique(numberList);
        System.out.println(uniqueNumbers);

        calcOccurrence(wordList);

        List<WordOccurrence> occurrences = findOccurrence(wordList);
        for (WordOccurrence wordOccurrence : occurrences) {
            System.out.println("Word: " + wordOccurrence.getName() + ", Occurrence: " + wordOccurrence.getOccurrence());
        }
    }

    // Метод countOccurrence
    public static int countOccurrence(List<String> wordList, String word) {
        int count = 0;
        for (String w : wordList) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    // Метод toList
    public static List<Integer> toList(Integer[] array) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : array) {
            list.add(num);
        }
        return list;
    }

    // Метод findUnique
    public static List<Integer> findUnique(List<Integer> numberList) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer num : numberList) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            }
        }
        return uniqueNumbers;
    }

    // Метод calcOccurrence
    public static void calcOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    // Клас WordOccurrence
    static class WordOccurrence {
        private String name;
        private int occurrence;

        public WordOccurrence(String name, int occurrence) {
            this.name = name;
            this.occurrence = occurrence;
        }

        public String getName() {
            return name;
        }

        public int getOccurrence() {
            return occurrence;
        }
    }

    // Метод findOccurrence
    public static List<WordOccurrence> findOccurrence(List<String> wordList) {
        List<WordOccurrence> occurrences = new ArrayList<>();
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            occurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        return occurrences;
    }
}