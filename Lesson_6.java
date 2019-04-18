package Lesson_6;

import java.util.Scanner;



abstract class Animals {
    protected String name;
    protected double maxJump;
    protected int maxRun;

    abstract void voice();
    abstract boolean swim(int swimLn);

    protected Animals(String name, double maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }
    boolean run(int runLn){
        return this.maxRun > runLn;
    }
    boolean jump(double jumpLn){
        return this.maxJump > jumpLn;
    }
}

class Cat extends Animals{
    int milk;

    public Cat(String name, double maxJump, int maxRun, int milk) {
        super(name, maxJump, maxRun);
        this.milk = milk;
    }

    @Override
    void voice() {
        System.out.println("  Мяу!!!");
    }

    @Override
    boolean swim(int swimLn) {
        return false;
    }
}

class Dog extends Animals{
    int swim;
    public Dog(String name, double maxJump, int maxRun, int swim) {
        super(name, maxJump, maxRun);
        this.swim = swim;
    }

    @Override
    void voice() {
        System.out.println("   Гав!!! Гав!!! ");
    }

    @Override
    boolean swim(int swimLn) {
        return this.swim > swimLn;
    }

}


class MainAnimals{

    public static void animalJump(Animals[]array){
        System.out.println("Пожалуйста задайте дистанцию прыжка 0 - 2 м (разделитель - запятая)");
        Scanner sc = new Scanner(System.in);
        double length = sc.nextDouble();
        for (int i = 0; i <array.length; i++) {
            System.out.println("Результаты - "+ array[i].name + " -> " + array[i].jump(length)); if (array[i].jump(length)) array[i].voice();
        }
    }



    public static void animalRun(Animals[]array){
        int ln = 0;
        System.out.println("Пожалуйста задайте дистанцию бега  0 - 600 м ");
        Scanner scInt = new Scanner(System.in);
        ln = scInt.nextInt();
        for (int i = 0; i <array.length; i++) {

            System.out.println("Результаты - " + array[i].name + " -> " + array[i].run(ln));
            if (array[i].run(ln)) array[i].voice();
        }
    }

    public static void animalSwim(Animals[]array){
        int swimDistance;
        System.out.println("Пожалуйста задайте дистанцию заплыва  0 - 15 м ");
        Scanner scInt = new Scanner(System.in);
        swimDistance = scInt.nextInt();

        for (int i = 0; i <array.length; i++) {

            System.out.println("Результаты - " + array[i].name + " -> " + array[i].swim(swimDistance));
            if (array[i].swim(swimDistance)) array[i].voice();
        }

    }


    public static void main(String[] args) {                                    // Entry Point

        Cat cat01 = new Cat("Barsik", 2, 200, 15);
        Dog dog01 = new Dog("Sharik",0.5,400, 10);
        Dog dog02 = new Dog("Druzhok",0.7,600, 15);

        Animals [] homeAnimals = {cat01, dog01, dog02};


        animalJump(homeAnimals);
        animalRun(homeAnimals);
        animalSwim(homeAnimals);
    }
}