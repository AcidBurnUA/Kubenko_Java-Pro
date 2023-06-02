package Homework12.phonebook;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        Entry entry1 = new Entry("John", "123456789");
        Entry entry2 = new Entry("Jane", "987654321");
        Entry entry3 = new Entry("John", "456789123");

        phonebook.add(entry1);
        phonebook.add(entry2);
        phonebook.add(entry3);

        Entry foundEntry = phonebook.find("Jane");
        if (foundEntry != null) {
            System.out.println("Found entry: " + foundEntry.getName() + ", " + foundEntry.getPhoneNumber());
        } else {
            System.out.println("Entry not found.");
        }

        List<Entry> foundEntries = phonebook.findAll("John");
        if (foundEntries != null) {
            System.out.println("Found entries:");
            for (Entry entry : foundEntries) {
                System.out.println(entry.getName() + ", " + entry.getPhoneNumber());
            }
        } else {
            System.out.println("No entries found.");
        }
    }
}
