package Homework17;
import java.util.ArrayList;
import java.util.List;
class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }

        Fruit fruit = fruits.get(0);
        float fruitWeight = fruit instanceof Apple ? 1.0f : 1.5f;
        return fruitWeight * fruits.size();
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void merge(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }

        if (!fruits.isEmpty() && !otherBox.fruits.isEmpty()) {
            throw new IllegalArgumentException("Both boxes must be empty before merging.");
        }

        this.fruits.addAll(otherBox.fruits);
        otherBox.fruits.clear();
    }
}
