package Lesson_1;

public class Lesson_01 {

    public static void main(String[] args){

        // целочисленные
        byte b1 = 4;
        int i1 = 444777;
        short s1 = 44;
        long l1 = 724444434L;

        // С плавающей запятой
        float fl1 = 4.2f;
        double d1 = 764.2;

        // логические и символьные
        boolean bool1 = true; // по дефолту "false"
        boolean bool2;
        char c1 = 'D'; //один символ
        String str1 = "Дмитрий Varenov"; //строка
        Integer int1 = -4;
        int i2 = 2019;
//Ниже обращения к методам - вывод результатов их работы
    d1 = calculation(99, 3.2, 2, 4); //результат работы метода задания №3, для проверки добавлено дробное число
        System.out.println("Результат операции:" + d1); // вывод результата работы метода задания №3
        bool1 = sum_check(4.44, 6); //результат работы метода задания №4
        System.out.println(bool1);  // вывод результата работы задания №4
        pos_neg(i1); // Вывод результата работы задания №5
    bool2 = negative_check (i1);
        System.out.println(bool2);
        hello(str1);
        Year(i2);
    }

//Задание №3. В принципе наверное можно задать и "int" но тогда теряется возможность работы с дробными числами
public static double calculation(double a, double b, double c, double d){
        return a*(b+(c/d));
    }
//Задание №4 В теории наверное можно сделать метод приватным, так как обращения идут из этого же класса, других классов нет???
private static boolean sum_check (double f, double g){
        double h = f + g;
        if (h>=10 && h<=20)
        return true;
else
    return false;
}
// Задание №5
private static void pos_neg(int i){
    System.out.println(i>=0 ? "Данное число ноль или положительное": "Данное число отрицательное");
}
//Задание №6
public static boolean negative_check (int i){
        if (i>=0)
        return false;
        else
        return true;
}
//Задание №7
public static void hello(String j){
      System.out.println("Привет, " + j);
}
//Задание №8
static private void Year(int y){
    if(y % 4 != 0){
        System.out.println(y + " год не високосный");
    }
    else if((y % 100 == 0) && (y % 400 != 0)) {
        System.out.println(y + " год не високосный");
    }
    else
        System.out.println(y + " год високосный");
}
}
