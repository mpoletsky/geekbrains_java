import java.util.Random;

public class Cource {

    final private String[] obstangles = {"Ров с водой", "Стена", "Горящий обруч"};

    public void dolt(Team team) {
        for (String obstangle:obstangles) {
            System.out.println("Препятствие \"" + obstangle + "\":");
            for (Member member:team.getTeam()) {
                Random random = new Random();
                boolean trueOrFalse = random.nextBoolean();
                String result = trueOrFalse ? "успешно" : "фиаско";
                System.out.println(member.getName() + ": " + result);
            }
            System.out.println();
        }
    }
}
