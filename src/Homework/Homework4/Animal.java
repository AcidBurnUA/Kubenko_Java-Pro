package Homework4;

public class Animal {
    private static int animalCount = 0;
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
}
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробіг " + distance + " м");
        } else {
            System.out.println(name + " не може пробігти більше " + runLimit + " м");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не вміє плавати");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплив " + distance + " м");
        } else {
            System.out.println(name + " не може пропливти більше " + swimLimit + " м");
        }
    }
    public static int getAnimalCount() {
        return animalCount;
    }
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобік");
        dogBobik.run(150);
        dogBobik.swim(5);

        Cat catMurzik = new Cat("Мурзик");
        catMurzik.run(250);
        catMurzik.swim(3);

        System.out.println("Створено тварин: " + Animal.getAnimalCount()); // Створено тварин: 2
        System.out.println("Створено собак: " + Dog.getDogCount()); // Створено собак: 1
        System.out.println("Створено котів: " + Cat.getCatCount()); // Створено котів: 1
    }
}
