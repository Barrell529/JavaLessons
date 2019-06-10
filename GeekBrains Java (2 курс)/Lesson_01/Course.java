public class Course {

    public int courseRunDistance;
    public double courseJumpDistance;
    public int courseSwimDistance;


    public Course(int courseRunDistance, double courseJumpDistance, int courseSwimDistance) {
        this.courseRunDistance = courseRunDistance;
        this.courseJumpDistance = courseJumpDistance;
        this.courseSwimDistance = courseSwimDistance;
    }

    public void teamDoIt(Team team) {
        boolean result = false;
        Player [] playerArr =  team.teamPlayerArray();

        for (int i = 0; i < playerArr.length; i++) {            // бегу бугу бегу

                if (playerArr[i].run() >= courseRunDistance) {
                    result = true;
                }

        }

            if (result){System.out.println("Все участники финишировали на дистанции в " + courseRunDistance + " метров");}
            result = false;

        for (int i = 0; i < playerArr.length; i++) {

            if (playerArr[i].jump() >= courseJumpDistance) {
                result = true;
            }

        }

        if (result){System.out.println("Все участники преодолели ров шириной " + courseJumpDistance + " метра(ов)");}
        result = false;

        for (int i = 0; i < playerArr.length; i++) {

            if (playerArr[i].swim() >= courseSwimDistance) {
                result = true;
            }

        }

        if (result){System.out.println("Все участники проплыли дистанцию в " + courseSwimDistance + " метров");}


        if (result) {
            System.out.println("Команда успешно прошла полосу препятствий. Ура Товарищи !!!");

        } else {
            System.out.println("Команда не прошла полосу препятствий");
        }
    }

    public void showCourse(){

        System.out.println("Дистанция забега - " + courseRunDistance + " м.; Ширина рва " + courseJumpDistance +" м.;  Дистанция заплыва " + courseSwimDistance + " м.;");
    }

}
