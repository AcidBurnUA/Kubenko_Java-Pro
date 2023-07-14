package Homework17;
import java.util.ArrayList;
import java.util.List;

// Завдання 1: Метод toList для перетворення масиву у список
class ArrayToListConverter {
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }
}