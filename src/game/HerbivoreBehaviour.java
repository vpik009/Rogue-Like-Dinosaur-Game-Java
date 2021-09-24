package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

/**
 * HerbivoreBehaviour implements Behaviour interface and hence needs to implement its getAction method
 * Used to allow actors, specific to herbivores to have its own unique actions
 */
public class HerbivoreBehaviour implements Behaviour {

    /**
     * Get the suitable action based on the environment the actor is in.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return If an item has a capability of being fed by herbivore, we move the actor to the item and eat the item by returning EatBySelfAction
     * If there is no fruit on the location and instead has grass then the actor should move towards it and eat the groundtype item by returning EatBySelfAction
     *  
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {


        List<Exit> exits = map.locationOf(actor).getExits();


        for(Exit exit : exits)
        {
            //get items on the exit
            List<Item> items = exit.getDestination().getItems();
            //get exit's ground type
            Ground groundType = exit.getDestination().getGround();

            for (Item item: items)
            { //! only follows if the food is close by (1 block away)
                if(item.hasCapability(DinoCapability.EAT_BY_SELF_HERBIVORE) && !exit.getDestination().containsAnActor())
                {
                    map.moveActor(actor, exit.getDestination()); //move to the item

                    return new EatItemAction(item); //eat the item
                }
            }
            if(groundType.hasCapability(DinoCapability.EAT_BY_SELF_HERBIVORE) && !exit.getDestination().containsAnActor()){
                map.moveActor(actor, exit.getDestination());
                return new EatGroundAction(groundType);
            }


        }
        return null;

    }



}
