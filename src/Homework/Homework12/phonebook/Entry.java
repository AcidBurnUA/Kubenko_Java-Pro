package Homework12.phonebook;

class Entry {
    private String name;
    private String phoneNumber;

    public Entry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
