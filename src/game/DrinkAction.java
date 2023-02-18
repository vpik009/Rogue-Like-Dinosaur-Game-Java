package game;

import edu.engine.Action;
import edu.engine.Actor;
import edu.engine.GameMap;
import edu.engine.Location;
/**
 * DrinkAction, extended from Action class is used an action that enables an actor to drink water and increase its thirst level.
 */
public class DrinkAction extends Action {

    /**
     * private attribute location, which is instantiated from Location class.
     */
    private Location location;

    /**
     * Public constructor to instantiate objects of this class
     * @param location , sets the location attribute of this instance to location parameter
     */
    public DrinkAction(Location location){
        this.location = location;
    }

    @Override
    /**
     * Executes the action to add thirst level to the actor that has performed DrinkAction.
     * @param actor , the actor that needs to die
     * @param map , the map the actor is on
     * @return string describing who has died
     */
    public String execute(Actor actor, GameMap map) {
        actor.addThirst(((Water)location.getGround()).foodToConsume()); //returns the thirst to gain for that drinkable type of ground
        return actor + " at ["+map.locationOf(actor).x()+"]"+map.locationOf(actor).y()+"] drinks " + location.getGround().getClass().getName().substring(5) + " and gains " + location.getGround().foodToConsume()+" to their thirst level";
    }

    @Override
    /**
     * descriptive description in the menu
     * @param actor , actor that could perform this action
     * @return string, a descriptive string to describe the option
     */
    public String menuDescription(Actor actor) {
        return actor + " drinks " + location.getGround().getClass().getName().substring(5);
    }
    
}
