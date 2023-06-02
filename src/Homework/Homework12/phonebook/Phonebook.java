package Homework12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Entry> entries;

    public Phonebook() {
        entries = new ArrayList<>();
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public Entry find(String name) {
        for (Entry entry : entries) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }
        return null;
    }

    public List<Entry> findAll(String name) {
        List<Entry> foundEntries = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getName().equals(name)) {
                foundEntries.add(entry);
            }
        }
        if (foundEntries.isEmpty()) {
            return null;
        }
        return foundEntries;
    }
}
