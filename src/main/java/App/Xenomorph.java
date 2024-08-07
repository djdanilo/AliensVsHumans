package App;

public class Xenomorph extends Alien {

    public Xenomorph() {
        super(160, "Xenomorph", Weapon.TAIL_WHIP, 2, .01);
    }


    protected String incubationSuccess() {
        return "Incubation success! Hugger inserted into host.";
    }

    protected String incubationFailure() {
        return "Target escaped.";
    }

    public String incubate(Character victim) {
        double incubationDamageThreshold = victim.getStartingHp() * .33;
        if (victim.getHp() < (int)incubationDamageThreshold) return this.incubationSuccess();
        return this.incubationFailure();
    }

    public String testSuccessMessage() {
        return this.incubationSuccess();
    }

    public String testFailureMessage() {
        return this.incubationFailure();
    }
}