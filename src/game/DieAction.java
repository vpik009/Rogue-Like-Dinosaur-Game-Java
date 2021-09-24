package game;
import edu.monash.fit2099.engine.*;

/**
 * DieAction is used when an actor should die in order to remove the actor from the map and spawn a corpse in its place
 */
public class DieAction extends Action {

    @Override
    /**
     * Executes the action to remove an actor from the map and spawn its corpse.
     * @param actor , the actor that needs to die
     * @param map , the map the actor is on
     * @return string describing who has died
     */
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof Stegosaur || actor instanceof BabyStegosaur) {
            StegosaurCorpse corpse = new StegosaurCorpse();
            map.locationOf(actor).addItem(corpse);
            map.removeActor(actor);
        } else if(actor instanceof Allosaur || actor instanceof BabyAllosaur){
            AllosaurCorpse corpse = new AllosaurCorpse();
            map.locationOf(actor).addItem(corpse);
            map.removeActor(actor);
        } else if(actor instanceof Agilisaurus || actor instanceof BabyAgilisaurus){
            AgilisaurusCorpse corpse = new AgilisaurusCorpse();
            map.locationOf(actor).addItem(corpse);
            map.removeActor(actor);
        }
        else {
            ArchaeopteryxCorpse corpse = new ArchaeopteryxCorpse();
            map.locationOf(actor).addItem(corpse);
            map.removeActor(actor);
        }
        return actor + " dies!";
    }

    @Override
    /**
     * descriptive description in the menu
     * @param actor , actor that could perform this action
     * @return string, a descriptive string to describe the option
     */
    public String menuDescription(Actor actor) {
        return actor + " dies!";
    }
}
