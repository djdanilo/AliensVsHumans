package App;

public class Alien extends Character{

    protected int rp;
    protected double rpMultiplier;

    public Alien(int hp, String species, Weapon weapon, int rp, double rpMultiplier) {
        super(hp, species, weapon);
        this.rp = rp;
        this.rpMultiplier = rpMultiplier;
    }

    private void setRp() {
        double researchGains = 100 * rpMultiplier;
        this.rp += (int)researchGains;
    }

    private String probeTargetFailed() {
        return "Hey you can't do that kind of stuff to another Alien!";
    }

    private String probeTargetSuccess() {
        return "Congratulations probe successful!";
    }

    public String initiateProbe(Character probeTarget) {
        if (probeTarget.getSpecies() == "human") {
            this.setRp();
            return this.probeTargetSuccess();
        } else {
            return this.probeTargetFailed();
        }
    }

    public String testProbeTargetSuccess() {
        return this.probeTargetSuccess();
    }

    public String testProbeTargetFailed() {

        return this.probeTargetFailed();
    }
}
