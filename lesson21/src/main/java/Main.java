public class Main {
    public static void main(String[] args) {
        Cource cource = new Cource();
        Team team = new Team(new Member("Петр"), new Member("Василий"), new Member("Илья"), new Member("Григорий"));
        cource.dolt(team);
    }
}
