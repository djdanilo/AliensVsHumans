package App;

public class Grey extends Alien {
    protected int probeCounter;

    public Grey() {
        super(60, "grey", Weapon.STUN_GUN, 38, .14);
        this.probeCounter = 0;

    }

    private void incrementProbeCounter() {
        this.probeCounter += 1;
    }

    private int getProbeCounter() {
        return this.probeCounter;
    }

    public String greyProbe(Character probeTarget) {
        this.incrementProbeCounter();
        return this.initiateProbe(probeTarget);
    }

    public String researchResults() {
        return "Congratulations you have successfully probed " + this.getProbeCounter() + " humans. You are getting closer to Earth domination! " + "Your research knowledge grows by one third the amount of humans you probed!";

    }

    public String research() {
        double researchGains = this.getProbeCounter() * .33;
        this.rp += (int)researchGains;
        return this.researchResults();
    }

}
