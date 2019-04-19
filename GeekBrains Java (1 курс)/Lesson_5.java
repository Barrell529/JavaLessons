package Lesson_5;

public class Lesson_5 {

    public static void main(String[] args) {

        Sotrudnik[] hr_array = new Sotrudnik[5];
        hr_array[0] = new Sotrudnik("Test Testovich Testov", "slave of the chairmen", "testv@yacorp.com", "666-66-66", 0, 45);
        hr_array[1] = new Sotrudnik("Yulia Yurievna Yurieva", "secretary", "Yurieva@yacorp.com", "777-77-77", 1000, 20);
        hr_array[2] = new Sotrudnik("Debug Debagovich Debagov", "Q&A Engineer", "debagov@yacorp.com", "555-55-55", 55000, 55);
        hr_array[3] = new Sotrudnik("Tupik Tupovich Tupikov", "Executive director", "tupoy@yacorp.com", "444-44-44", 2000000, 54);
        hr_array[4] = new Sotrudnik("Ivan Koderovich Programmistov", "programmer", "programmistov@yaorp.com", "333-33-33", 200, 19);

//
        for( int i = 0; i< 4;i++)
    {
        if (hr_array[i].age > 40) {
            hr_array[i].info();

        }
    }
    }
}
class Sotrudnik {

    String fio;
    String duty;
    String email;
    String tel_number;
    int salary;
    int age;

            public Sotrudnik(String fio, String duty, String email, String tel_number, int salary, int age) {
                this.fio = fio;
                this.duty = duty;
                this.email = email;
                this.tel_number = tel_number;
                this.salary = salary;
                this.age = age;


            }

            public void info() {
                System.out.println(fio + " / " + duty + " / " + age + " | " + salary + " / " + email + " / " + tel_number);


            }
        }