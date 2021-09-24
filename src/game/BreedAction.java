package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * BreedAction inherits from Action. 
 * Used to allow actors to breed by setting female Actor of the two, to pregnant.
 */
public class BreedAction extends Action {
    /**
     * private attribute used to specify which target the actor want to breed with
     */
    private Actor target;

    /**
     * public constructor to instantiate objects of this class
     * @param target , Actor type to specify the target the actor executing this action wants to breed with
     */
    public BreedAction(Actor target) {
        this.target = target;
    }

    /**
     * Executes the breedAction. Checks who is the female, and sets them to pregnant.
     *
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a string specifying which one of the actors was set to pregnant
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Actor change;
        

            //set female to be pregnant
            if (actor.getMale())
            {
                target.setPregnant(true);
                change = target;
            } 
            else 
            {
                actor.setPregnant(true);
                change = actor;
            }
        

        return change + " at [" + map.locationOf(change).x() + "]["+map.locationOf(change).y() +"] is now pregnant";
    }

    /**
     * Describes the action as it would be performed from the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is now pegnant ";
    }

    
}
