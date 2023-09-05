// Абстрактный класс Животное
abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected static int count;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не умеет плавать так далеко.");
        }
    }

    public static int getCount() {
        return count;
    }

    public abstract void info();
}

// Класс Собака
class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10);
    }

    @Override
    public void info() {
        System.out.println("Собака: " + name);
    }
}

// Класс Кот
class Cat extends Animal {
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        this.satiety = false;
    }

    public void eat(int foodAmount) {
        if (foodAmount > 0) {
            satiety = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println(name + " не нашел еду в миске.");
        }
    }

    @Override
    public void info() {
        System.out.println("Кот: " + name);
    }

    public boolean isSatiety() {
        return satiety;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");

        dog.info();
        dog.run(300);
        dog.swim(5);

        cat1.info();
        cat1.run(150);
        cat1.swim(2);

        cat2.info();
        cat2.run(250);
        cat2.swim(0);

        int catCount = Cat.getCount();
        System.out.println("Всего создано котов: " + catCount);

        cat1.eat(5);
        cat2.eat(0);

        System.out.println("Сытость кота " + cat1.name + ": " + cat1.isSatiety());
        System.out.println("Сытость кота " + cat2.name + ": " + cat2.isSatiety());
    }
}
