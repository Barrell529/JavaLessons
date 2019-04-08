package Lesson_2;

import java.util.Arrays;

public class Lesson_02 {

    // Задание №1 - заменяем нули на единицы
    public static void main(String[] args) {
        int[] massive = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // используется для проверки работоспособности задания №1
        int[] massive1 = new int[8]; // используется для проверки работоспособности задания №2
        int[] massive2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // используется для проверки работоспособности задания №3 и 5
        int[][] massive3 = new int[4][4]; // используется для проверки работоспособности задания №4
        int [] massive4 = {4, 1, 2, 5, 3, 4, 3, 2}; // используется для проверки работоспособности задания №6 и 7
        int [] massive5 = {4, 4, 4, 4, 10, 2, 1, 5}; // используется для проверки работоспособности задания №6


        System.out.println("Исходный массив данных " + Arrays.toString(massive));
        for (int i = 0; i < massive.length; i++)
            if (massive[i] == 0)
                massive[i] = 1;
            else
                massive[i] = 0;
        System.out.println("Видоизмененный массив данных " + Arrays.toString(massive));

        //Вызов методов реализующих задания 2-7. Проверка работоспособности

        massive_size(massive1); // Вызов метода задания № 2
        massive_check(massive2); // Вызов метода задания № 3
        square_massive(massive3); // Вызов метода задания № 4
        printMatrix(massive3); //Дебагинг. Упрощение вывода в консоль двумерных массивов.
        search_min_man (massive2); // Вызов метода задания № 5
        System.out.println(checkBalance(massive4)); // Вызов метода задания № 6
        System.out.println(checkBalance(massive5)); // Вызов метода задания № 6
        movement(massive4, 4); // Вызов метода задания № 7
        System.out.println(Arrays.toString(massive4)); // Вызов метода задания № 7
    }

    // Задание № 2 - Заполнить пустой массив указанными значениями
    public static void massive_size(int[] massive1) {

        for (int i = 0; i < massive1.length; i++)
            massive1[i] = i * 3; // Вероятно неправильный подход. Но учитывая указанные в задании цифры - работает.
        System.out.println("Вывод данных массива " + Arrays.toString(massive1));
    }

    //Задание № 3 - Умножаем элементы массива < 6 на 2.
    public static void massive_check(int[] massive2) {
        System.out.println("Вывод данных массива до умножения " + Arrays.toString(massive2));
        for (int i = 0; i < massive2.length; i++)
            if (massive2[i] < 6)
                massive2[i] = massive2[i] * 2;
        System.out.println("Вывод данных массива после умножения " + Arrays.toString(massive2));
    }

    //    Задание № 4 - Заполняем диагональные элементы массия единицами.
    public static void square_massive(int[][] massive3) {
        for (int i = 0; i < massive3.length; i++) {
                massive3[i][i] = 1; //Для первой диагонали координаты строки/столбца совпадают
                massive3[i][massive3.length - 1 -i] = 1;
            }
        }
//Дополнительный метод для упрощения вывода матриц в консоль.
// Упрощаем процесс. Кунг-фу подсказано Павловым В.А. :-)

    static private void printMatrix(int[][] massive3){
        for (int[] i: massive3) {
            for (int j: i) {
                System.out.print(j);
            }
          System.out.println();
        }
    }
    // Задание № 5 - Ищем минимальный и максимальный элементы массивов
    //Используется массив-2. соответственно его элементы <6 были умножены на 2 после выполнения задания №3
    public static void search_min_man(int[] massive2) {
        int max = 0;
        int min = massive2[0];
        for (int i = 0; i < massive2.length; i++) {
            if (massive2[i] > max ) {
                max = massive2[i];
            }
            if (massive2[i] < min) {
                min = massive2[i];
            }
             }
        System.out.println("Максимальный элемент = " + max);
        System.out.println("Минимальный элемент = " + min);
    }

//    Задание №6 - Проверка сумм левой и правой частей массива.
    static private boolean checkBalance(int[] ar){

        int cycles = ar.length - 1;
        for (int i = 0; i < cycles; i++) {
            int Left_sum = 0, Right_sum = 0;
            for (int j = 0; j < i; j++) {
                Left_sum += ar[j];
            }
            for (int j = i; j < ar.length; j++) {
                Right_sum += ar[j];
            }
            if(Left_sum == Right_sum) {
                return true;
            }
        }
        return false;
    }
// Задание №7 - смещение элементов массива на указанный "Критерий смещения"
    static private void movement(int[] ar, int n){
        // Проверка введенного "критерия смещения" если положительный - ползем вправо иначе влево
        if(n>0){
            // Если правльно понимаю в случае если "критерий смещения" окажется равным общей длинне массива,
            // то исходный массив равен измененному, а значит исключаем целое число длин массивов и смещаем только на остаток
            int k = n % ar.length;
            for (int i = 0; i < k; i++) {
                int m = ar[ar.length-1];
                for (int j = ar.length-1; j > 0; j--) {
                    ar[j] = ar[j-1];
                }
                ar[0] = m;
            }
            // Ползем влево ибо значение отрицательное
        } else {
            int k = n % ar.length;
            for (int i = 0; i > k ; i--) {
                int m = ar[0];
                for (int j = 0; j < ar.length-1; j++) {
                    ar[j] = ar[j+1];
                }
                ar[ar.length-1] = m;
            }
        }
    }
    }