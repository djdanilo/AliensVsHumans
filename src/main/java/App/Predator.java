package App;

public class Predator extends Alien {

    public Predator() {
        super(120, "zurg", Weapon.SONIC_SPEAR, 11, .06);
    }

    protected String captureSuccess() {
        return "The victim was too fatigued to evade capture! They have been bound in chains and await mothership extraction. Long live the zurg empire!";
    }

    protected String captureFailure() {
        return "Target escaped! We will have to wear them down a little more.";
    }

    public String capture(Character victim) {
        double captureDamageThreshold = victim.getStartingHp() * .20;

        if (victim.getHp() < (int)captureDamageThreshold) return this.captureSuccess();
        return this.captureFailure();

    }

    public String testCaptureSuccessMessage() {
        return this.captureSuccess();
    }

    public String testCaptureFailureMessage() {
        return this.captureFailure();
    }
}
