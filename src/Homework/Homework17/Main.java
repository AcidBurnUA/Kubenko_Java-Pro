package Homework17;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Завдання 1: Перетворення масиву у список
        Integer[] numbersArray = {1, 2, 3, 4, 5};
        List<Integer> numbersList = ArrayToListConverter.toList(numbersArray);
        System.out.println(numbersList);

        // Завдання 2: Робота з коробками фруктів
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // Вага коробок
        System.out.println("Apple Box 1 weight: " + appleBox1.getWeight()); // Вага: 2.0
        System.out.println("Apple Box 2 weight: " + appleBox2.getWeight()); // Вага: 1.0
        System.out.println("Orange Box weight: " + orangeBox.getWeight()); // Вага: 4.5

        // Порівняння коробок
        System.out.println("Apple Box 1 equals Apple Box 2: " + appleBox1.compare(appleBox2)); // false
        System.out.println("Apple Box 1 equals Orange Box: " + appleBox1.compare(orangeBox)); // true

        // Злиття коробок
        Box<Apple> appleBox3 = new Box<>();
        appleBox3.addFruit(new Apple());
        appleBox3.addFruit(new Apple());

        appleBox1.merge(appleBox3);

        System.out.println("Apple Box 1 weight after merging: " + appleBox1.getWeight()); // Вага: 4.0
        System.out.println("Apple Box 3 weight after merging: " + appleBox3.getWeight()); // Вага: 0.0
    }
}
