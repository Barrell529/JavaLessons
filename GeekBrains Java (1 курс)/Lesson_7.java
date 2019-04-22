package Lesson_7;

public class Lesson_7 {

    static public void main(String[] args) {
        Cat[] cats = {new Cat("Мурзик", 20),
                new Cat("Белый", 25),
                new Cat("Беляш", 30),
                new Cat("Кошак", 20),
                new Cat("Черныш", 15)
        };
        Plate plate = new Plate(75);

        feedCats(cats, plate);
        getCatsInfo(cats);
        plate.info();
        plate.addFood(50);
        feedCats(cats, plate);
        getCatsInfo(cats);
        plate.info();
        plate.addFood(10);
        plate.info();
    }

    static private void feedCats(Cat[] cats, Plate plate){
        for (Cat cat : cats) {
            if(!cat.isFull()) {
                if(cat.eat(plate)) {
                    System.out.println(cat.getName() + " ел из миски.");
                }else {
                    System.out.println("Коту " + cat.getName() + " не хватило жратвы");
                }
            } else {
                System.out.println(cat.getName() + " сытый, есть не будет");
            }
        }
    }

    static private void getCatsInfo(Cat[] cats){
        for (Cat cat: cats) {
            System.out.println(cat.getName() + (cat.isFull() ? " сыт." : " голоден."));
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean full;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    boolean isFull() {
        return full;
    }

    String getName() {
        return name;
    }

    boolean eat(Plate p) {
        if(p.getFood()>appetite){
            p.decreaseFood(appetite);
            full = true;
            return true;
        }
        return false;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    int getFood() {
        return food;
    }

    void decreaseFood(int food) {
        this.food -= food;
    }

    void addFood(int food) {
        this.food += food;
    }

    void info(){
        System.out.println("В миске осталось " + food + " единиц еды.");
    }
}
