package Homework7;
public class Main {
    public static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }
    public static int findWordPosition(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (source.contains(target)) {
            return source.indexOf(target);
        } else {
            return -1;
        }
    }
    public static String stringReverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = stringReverse(str);
        return str.equals(reversed);
    }
}