package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import App.*;
import App.Character;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

class AvhTest {
    Human arnold;
    Grey blip;
    Predator zarg;
    Xenomorph queen;
    Hugger baby;
    Character[] listOfCharacters;
    Alien[] listOfAliens;


    @BeforeEach
    public void beforeTests() {
        arnold = new Human();
        blip = new Grey();
        zarg = new Predator();
        queen = new Xenomorph();
        baby = new Hugger();
        listOfCharacters = new Character[] {arnold, blip, zarg, queen, baby};
        listOfAliens = new Alien[] {blip, zarg, queen, baby};
    }


    private HashMap<String, TranslatorObjects> speciesTranslationMap() {
        Translators translations = new Translators();
        return translations.getTranslationHashMap();
    }

    @Test
    public void probedStatus() {
        boolean probeStatus = arnold.getProbeStatus();
        assertFalse(probeStatus);
    }

    @Test
    public void probePossible() {

        for (Alien prober: listOfAliens) {
            assertFalse(arnold.getProbeStatus());
            assertEquals(prober.testProbeTargetSuccess(), prober.initiateProbe(arnold));
            arnold.setProbeStatus(true);
            assertTrue(arnold.getProbeStatus());
            arnold.setProbeStatus(false);
        }
    }

    @Test
    public void noIllegalProbing() {

        for (Alien prober: listOfAliens) {
            for (Alien target: listOfAliens){
                assertEquals(prober.testProbeTargetFailed(), prober.initiateProbe(target));
            }
        }
    }


    @Test
    public void canCommunicate() {
        Alien[] notArnold = {blip, zarg, queen, baby};
        assertEquals(arnold.testSuccessfulCommunication(), arnold.attemptCommunication(arnold));

        for (Alien nonHuman : notArnold) {
            assertEquals(arnold.testFailedCommunication(), arnold.attemptCommunication(nonHuman));
        }

        Character[] notBlip = {arnold, zarg, queen, baby};
        assertEquals(blip.testSuccessfulCommunication(), blip.attemptCommunication(blip));

        for (Character nonGrey : notBlip) {
            assertEquals(blip.testFailedCommunication(), blip.attemptCommunication(nonGrey));
        }

        Character[] notZarg = {arnold, blip, queen, baby};
        assertEquals(zarg.testSuccessfulCommunication(), zarg.attemptCommunication(zarg));

        for (Character nonPredator : notZarg) {
            assertEquals(zarg.testFailedCommunication(), zarg.attemptCommunication(nonPredator));
        }

        Character[] notQueen = {arnold, blip, zarg, baby};
        assertEquals(queen.testSuccessfulCommunication(), queen.attemptCommunication(queen));

        for (Character nonXenomorph : notQueen) {
            assertEquals(queen.testFailedCommunication(), queen.attemptCommunication(nonXenomorph));
        }

        Character[] notBaby = {arnold, blip, zarg, queen};
        assertEquals(baby.testSuccessfulCommunication(), baby.attemptCommunication(baby));

        for (Character nonBaby : notBaby) {
            assertEquals(baby.testFailedCommunication(), baby.attemptCommunication(nonBaby));
        }
    }

    @Test
    public void communicationWithTranslator() {
        HashMap<String, TranslatorObjects> translatorBySpecies = this.speciesTranslationMap();

        for (App.Character diplomat: listOfCharacters) {
            String translationSpecies = diplomat.getSpecies();
            TranslatorObjects rosetaStone = translatorBySpecies.get(translationSpecies);

            for(Character foreignBeing: listOfCharacters) {
                if (foreignBeing.getSpecies() != translationSpecies) {
                    assertEquals(foreignBeing.testFailedCommunication(), foreignBeing.attemptCommunication(diplomat));
                    foreignBeing.addTranslatorObject(rosetaStone);
                    assertEquals(foreignBeing.testSuccessfulCommunication(), foreignBeing.attemptCommunication(diplomat));
                }

            }
        }
    }

    @Test
    public void damageTest() {

        for (Character target: listOfCharacters) {
            int startingHp = target.getHp();
            target.takeDamage(10);
            assertEquals(startingHp - 10, target.getHp());
        }
    }

    @Test
    public void healTest() {
        for (Character target: listOfCharacters) {
            int startingHp = target.getHp();
            target.healHp(10);
            assertEquals(startingHp + 10, target.getHp());
        }
    }

    @Test
    public void attackTest() {
        for (Character attacker: listOfCharacters) {
            for (Character enemy: listOfCharacters) {
                int startingHp = enemy.getHp();
                attacker.attackEnemy(enemy);

                if (attacker.getSpecies() != enemy.getSpecies()){
                    assertNotEquals(startingHp, enemy.getHp());


                } else {
                    assertEquals(startingHp, enemy.getHp());
                }
            }
        }
    }

    @Test
    public void compassTest() {
        for (Character explorer: listOfCharacters) {
            assertEquals("NORTH", explorer.getDirection());
            explorer.changeDirection("left");
            assertEquals("WEST", explorer.getDirection());
            explorer.changeDirection("right");
            explorer.changeDirection("right");
            assertEquals("EAST", explorer.getDirection());
            explorer.changeDirection("right");
            assertEquals("SOUTH", explorer.getDirection());
            explorer.changeDirection("aboutFace");
            assertEquals("NORTH", explorer.getDirection());
        }
    }

    @Test
    public void predatorCaptureTest() {

        for (Character prey: listOfCharacters) {
            int startingHp = prey.getHp();
            double damageNeededToCapture = startingHp *.90;
            assertEquals(zarg.testCaptureFailureMessage(), zarg.capture(prey));
            prey.takeDamage((int)damageNeededToCapture);
            assertEquals(zarg.testCaptureSuccessMessage(), zarg.capture(prey));
        }
    }

    @Test
    public void xenomorphIncubateTest() {

        for (Character host: listOfCharacters) {
            int startingHp = host.getHp();
            double damageNeededToIncubate = startingHp * .77;
            assertEquals(queen.testFailureMessage(), queen.incubate(host));
            host.takeDamage((int)damageNeededToIncubate);
            assertEquals(queen.testSuccessMessage(), queen.incubate(host));
        }
    }

    @Test
    public void babyBurstTest() {
        String burstMessage = "The face hugger burst out of the bloated corpse!";
        assertEquals(burstMessage, baby.burst());
    }

    @Test
    public void babyMorphTest() {
        String morphMessage = "After emerging from it's cacoon the hugger became a full adult Xenomorph!";
        assertEquals(morphMessage, baby.morph());
    }
}