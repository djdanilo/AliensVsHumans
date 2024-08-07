package App;

enum Weapon {
    BASEBALL_BAT("human", .08),
    KNIFE("human", .10),
    HAND_GUN("human", .15),
    STUN_GUN("grey", .03),
    NOISE_BLASTER("grey", .06),
    RAY_GUN("grey", .09),
    SONIC_SPEAR("zurg",.18),
    PLASMA_CANNON("zurg",.24),
    SEEKER_MISSLE("zurg",.45),
    TAIL_WHIP("xenomorph", .17),
    GUTTING_CLAW("xenomorph", .33),
    SHREDDING_BITE("xenomorph", .77),
    FACE_LEAP("babyXenomorph", .15);

    public String speciesWields;
    public double damageMultiplier;

    Weapon(String speciesWields, double damageMultiplier) {
        this.speciesWields = speciesWields;
        this.damageMultiplier = damageMultiplier;
    }

}
