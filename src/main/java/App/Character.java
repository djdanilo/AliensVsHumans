package App;

import java.util.ArrayList;
import java.util.HashMap;

public class Character implements Communicate{

    protected int hp;
    protected int startingHp;
    protected String species;
    protected Weapon weapon;
    protected ArrayList<TranslatorObjects> translatorObjects;
    protected Compass compass;
    protected HashMap<String, TranslatorObjects> translationHashMap;

    public Character(int hp, String species, Weapon weapon) {
        this.hp = hp;
        this.startingHp = this.hp;
        this.species = species;
        this.weapon = weapon;
        this.compass = new Compass();
        this.translatorObjects = new ArrayList<>();
        this.translationHashMap = this.getTranslationHashMap();
    }

    private HashMap<String, TranslatorObjects> getTranslationHashMap() {
        Translators translators = new Translators();
        return translators.getTranslationHashMap();
    }

    public void attackEnemy(Character enemy) {
        if (enemy.getSpecies() != this.getSpecies()) {
            double damage = this.weapon.damageMultiplier * 100;
            enemy.takeDamage((int)damage);
            System.out.println("You attacked the enemy with your " + this.weapon + ". It was dealt " + damage + " damage!");
        } else {
            System.out.println("You realize the figure you were going to attack was indeed a " + this.species + ".");
        }
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public void healHp(int healing) {
        this.hp += healing;
    }

    public void addTranslatorObject(TranslatorObjects newCommunicationDevice) {
        this.translatorObjects.add(newCommunicationDevice);
    }

    public int getHp() {
        return this.hp;
    }

    public int getStartingHp() {
        return this.startingHp;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getDirection() {
        return this.compass.getDirection();
    }

    public void changeDirection(String direction) {
        this.compass.changeDirection(direction);
    }

    private boolean canCommunicate(String targetSpecies) {
        if (this.getSpecies() == targetSpecies || this.translatorObjects.contains(translationHashMap.get(targetSpecies))) {
            return true;
        } else {
            return false;
        }
    }

    private String successfulCommunication() {
        return "Hello I am a " + this.getSpecies() + ". I come in peace? Who are you?";
    }

    private String failedCommunication() {
        return "That monster is not a " + this.getSpecies() + "! RUN AWAY!!!";
    }

    @Override
    public String attemptCommunication(Character communicationTarget) {
        if (this.canCommunicate(communicationTarget.getSpecies())) {
            return this.successfulCommunication();
        } else {
            return this.failedCommunication();
        }

    }

    @Override
    public String testSuccessfulCommunication() {
        return this.successfulCommunication();
    }

    @Override
    public String testFailedCommunication() {
        return this.failedCommunication();
    }
}
