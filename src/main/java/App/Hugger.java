package App;

public class Hugger extends Alien {

    public Hugger() {
        super(30, "babyXenomorph", Weapon.FACE_LEAP, 1, .001);
    }

    public String burst() {
        return "The face hugger burst out of the bloated corpse!";
    }

    public String morph() {
        return "After emerging from it's cacoon the hugger became a full adult Xenomorph!";
    }
}
