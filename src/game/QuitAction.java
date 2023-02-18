package game;

import edu.engine.Action;
import edu.engine.Actor;
import edu.engine.GameMap;

/**
 * This is a public class that extends Action. This is to perform quit action for a player.
 */
public class QuitAction extends Action {

    @Override
    /**
     * This method is to throw a RuntimeError
     * @param actor , the actor that needs to die
     * @param map , the map the actor is on
     */
    public String execute(Actor actor, GameMap map) {
        throw new QuitToMenuError();
        
    }

    @Override
    /**
     * descriptive description in the menu
     * @param actor , actor that could perform this action
     * @return string, a descriptive string to describe the option
     */
    public String menuDescription(Actor actor) {
        return "Quit";
    }
    
}
