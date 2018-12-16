public class Team {

    private String name;

    private Member[] team = new Member[4];

    Team(Member member1, Member member2, Member member3, Member member4) {
        this.team[0] = member1;
        this.team[1] = member2;
        this.team[2] = member3;
        this.team[3] = member4;
    }

    public void members_info() {
        System.out.println("Участники:");
        for (Member member:team) {
                System.out.println(member.getName());
        }
    }

    public void passed_distance_members_info() {
        System.out.println("Участники, прошедшие дисанцию:");
        for (Member member:team) {
            if (member.isDistancePassed()) {
                System.out.println(member.getName());
            }
        }
    }

    public Member[] getTeam() {
        return team;
    }
}
