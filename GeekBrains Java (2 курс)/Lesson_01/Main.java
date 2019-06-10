public class Main {

    public static void main(String[] args) {
        Player [] argo = new Player[4];
        argo[0] = Team.player1;
        argo[1] = Team.player2;
        argo[2] = Team.player3;
        argo[3] = Team.player4;
        Team newTeam = new Team("Losers", argo);
        Course course = new Course(1,300,1);

        System.out.println(newTeam.toString());
        course.showCourse();



        course.teamDoIt(newTeam);





    }
}

