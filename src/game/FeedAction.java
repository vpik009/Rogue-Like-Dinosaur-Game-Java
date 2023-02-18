package game;

import edu.engine.*;

/**
 * A public class FeedAction that is extended from Action that allows to perform feed action
 */
public class FeedAction extends Action {

    /**
     * A private Actor targer
     */
    private Actor target;

    /**
     * A private Feedable item
     */
    private PortableItem item;

    /**
     * A public constructor that initialises target and item
     * @param target
     * @type Actor class
     * @param item
     * @type Feedable
     */
    public FeedAction(Actor target, PortableItem item){
        this.target = target;
        this.item = item;
    }


    /**
     * Perform the Action of feeding.
     * The target has to be conscious and add food level to the target after being fed. Otherwise, we heal the target as well
     * After that, we remove the item used to feed and add eco points to the player.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {


            if(target.isConscious()){
                target.addFood(item.foodToConsume());
            }
            else{
                target.addFood(item.foodToConsume());
                target.heal(item.foodToConsume()); //set health to the items food level
            }
            actor.removeItemFromInventory((Item) item);
            ((Player) actor).addEco(((Feedable)item).getAddEco());
            return actor+" Feeds "+target +" at [" + map.locationOf(target).x() + "]["+map.locationOf(target).y() +"] "+item+". "+target+" has been fed for " + item.foodToConsume() + " food points and player gained "+((Feedable)item).getAddEco()+" eco points" ;

    }

    /**
     * Returns a descriptive string of feeding action
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "feed "+target+" "+item;
    }


}
