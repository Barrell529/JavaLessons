package Lesson_3;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Lesson_3 {
    public static void main(String[] args) {
        Random r = new Random();
        int guess_number = r.nextInt(9);
        int try_number = 0;
        int guess;
        Scanner vvod = new Scanner(System.in);
        while (try_number <= 2) {
            System.out.println("Угадай загаданное число межу 0 и 9");
            System.out.print("Введите ваше чиcло: ");
            guess = vvod.nextInt();
            try_number++;
            if (guess == guess_number) {
                System.out.println("Угадал, молодец! Попытка номер " + try_number);
            } else if (guess > guess_number) {
                System.out.println("Не угадал. Попробуй загадать число поменьше. Попытка номер " + try_number);
                System.out.print("Введите ваше чиcло: ");
            } else if (guess < guess_number) {
                System.out.println("Не угадал. Попробуй загадать число побольше. Попытка номер " + try_number);
                System.out.print("Введите ваше чиcло: ");
            }
        }
    }
}