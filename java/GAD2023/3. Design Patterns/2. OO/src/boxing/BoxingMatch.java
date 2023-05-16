package boxing;

public class BoxingMatch {
    private final Fighter fighter1;
    private final Fighter fighter2;
    public BoxingMatch(Fighter f1, Fighter f2) {
        this.fighter1 = f1;
        this.fighter2 = f2;
    }

    public String fight() {
        String winner = "";

        while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0) {
            fighter1.attack(fighter2);
            if (fighter2.getHealth() > 0) {
                fighter2.attack(fighter1);
                if (fighter1.getHealth() <= 0) {
                    winner = fighter2.toString();
                }
            }
            else {
                winner = fighter1.toString();
            }
        }

        return winner;
    }
}
