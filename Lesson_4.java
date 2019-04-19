package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {

    static private char PL_CHAR = 'X';
    static private char CPU_CHAR = 'O';
    static private char EMPTY_FIELD = '.';
    static private int SIZE_X = 3; //Статический размер поля по X
    static private int SIZE_Y = 3; //Статический размер поля по Y

    static private Scanner vvod = new Scanner(System.in);
    static private Random random = new Random();

    static public void main(String[] args){
        game_static();
    }
    static private void game_static(){
        char[][] standardField = new char[SIZE_X][SIZE_Y];
        boolean victory;
        Clear_field(standardField);
        Field_output(standardField);
        do {
            playerTurn(standardField);
            Field_output(standardField);
            victory = checkWinner(standardField, PL_CHAR);
            if(victory){
                System.out.println("Мешок с костями победил, радуйся, пока можешь");
                break;
            }
            if(Cell_check(standardField)) {
                break;
            }
            cpuTurn(standardField);
            Field_output(standardField);
            victory = checkWinner(standardField, CPU_CHAR);
            if(victory){
                System.out.println("Вся власть машинам!");
                break;
            }
        } while (!Cell_check(standardField));
        if(!victory) {
            System.out.println("Ну будем считать что ничья... пока что");
        }

    }
    static private boolean Cell_check (char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == EMPTY_FIELD){
                    return false;
                }
            }
        }
        return true;
    }

    static private void Clear_field(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = EMPTY_FIELD;
            }
        }
    }
    static private void Field_output(char[][] array){
        System.out.print("_|");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+1 + "|");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+1 + "|");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }
    // Кастом для нестандартного игрового поля
    static private boolean checkCell(int x, int y, char[][] array){
        if(x<0 || x>array.length || y<0 || y>array[0].length){
            return false;
        }
        return array[x][y] == EMPTY_FIELD;
    }

    static private void playerTurn(char[][] array){
        System.out.println("Ваш ход, введите координаты X и Y:");
        int x = vvod.nextInt()-1;
        int y = vvod.nextInt()-1;
        while (!checkCell(x, y, array)) {
            System.out.println("Координаты не верны или в данную ячейку уже осуществлен ход, введите координаты X и Y повторно:");
            x = vvod.nextInt()-1;
            y = vvod.nextInt()-1;
        }
        array[x][y] = PL_CHAR;
    }
    static private void cpuTurn(char[][] array){
        System.out.println("Ход машины");
        int x = random.nextInt(array.length);
        int y = random.nextInt(array[0].length);
        while (!checkCell(x, y, array)) {
            x = random.nextInt(array.length);
            y = random.nextInt(array[0].length);
        }
        array[x][y] = CPU_CHAR;
    }

    static private boolean checkWinner(char[][] array, char sym){
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == sym)
                    sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[j][i] == sym)
                    sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i][i] == sym){
                sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i][array.length - i - 1] == sym){
                sum++;
            }
            if(sum == 3) {
                return true;
            }
        }
        return false;
    }
}
