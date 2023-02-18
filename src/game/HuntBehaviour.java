package game;

import java.util.List;

import edu.engine.Action;
import edu.engine.Actor;
import edu.engine.Exit;
import edu.engine.GameMap;
import edu.engine.Item;

public class HuntBehaviour implements Behaviour {

    @Override
    /**
     * Allow for allosaur and archaeopteryx to attack an specific target, which is found by using exits.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return AttackAction if suitable target is found and is nearby or return null.
     */
    public Action getAction(Actor actor, GameMap map) {
        
        List<Exit> exits = map.locationOf(actor).getExits();

        for (Exit exit : exits) {
            // get items on the exit
            List<Item> items = exit.getDestination().getItems();

            if (exit.getDestination().containsAnActor()) { // Prioritize attacking stegosaur type dinosaurs
                Actor target = exit.getDestination().getActor();

                if ( (actor instanceof Allosaur && (target instanceof Stegosaur || target instanceof BabyStegosaur || target instanceof Agilisaurus || target instanceof BabyAgilisaurus)) 
                || 
                (actor instanceof Archaeopteryx && !(target instanceof Archaeopteryx || target instanceof BabyArchaeopteryx))) {
                                
                    return new AttackAction(target);
                }

            }


        }
        return null;
    }

    
}
