package App;

public class Human extends Character{

    protected boolean isProbed;

    public Human() {
        super(100, "human", Weapon.BASEBALL_BAT);
        this.isProbed = false;
    }

    public boolean getProbeStatus() {
        return this.isProbed;
    }

    public void setProbeStatus(boolean status)  {
        this.isProbed = status;
    }
}
