public class Member {

    private String name;

    private boolean isDistancePassed;

    Member(String name) {
        this.name = name;
        this.isDistancePassed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDistancePassed() {
        return isDistancePassed;
    }
}
