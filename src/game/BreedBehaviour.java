package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * BreedBehaviour implements Behaviour interface and hence needs to implement its getAction method
 * Used to allow actors to breed by fuinding a suitable target to breed with and returning and appropriate action
 */
public class BreedBehaviour implements Behaviour {

    /**
     * The target the actor with this behaviour wants to breed with
     */
    private Actor target;

    @Override
    /**
     * Get the suitable action based on the environment the actor is in.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return BreedAction if suitable target is found and is nearby or MoveActorAction to move closer to the suitable target 
     * if a suitable target has been found or null if no suitable target has been found
     */
    public Action getAction(Actor actor, GameMap map) {

        this.target = getTarget(actor, map);
        if(target == null) {
            //if no suitable target is found instantly return null
            return null;
        }

        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int currentDistance = distance(here, there);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (currentDistance!=1 && newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
                else if(currentDistance==1){
                    return new BreedAction(target);
                }
            }
        }
        //return null if no acceptable target to mate with.
        return null;
    }

    /**
     * Private method used to find the distance between two locations on a map
     * @param a , the first location  of type Location
     * @param b , the second location of type Location
     * @return integer, that is equal to the distance between two locations
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    /**
     * private method used to get the suitable target 
     * @param actor , the actor who is looking for a partner to mate with 
     * @param map , the map the actor is on
     * @return a suitable target if a suitable target has been found anywhere on the map or null if no suitable target has been found
     */
    private Actor getTarget(Actor actor, GameMap map){
        for (int i = 0; i < map.getXRange().max() ; i++) {
            for (int j = 0; j < map.getYRange().max(); j++) 
            {
                if(!(map.at(i,j).getActor() instanceof Player) && map.at(i,j).containsAnActor())
                {
                    Actor actorTest = map.at(i,j).getActor();
                
                    if(actorTest.getMale() != actor.getMale()&& actorTest.getClass().equals(actor.getClass()) && actor != actorTest && !actor.getPregnant() && ! actorTest.getPregnant() &&actorTest.getFoodLevel()>=50)
                    {
                        return actorTest;
                    }
                }
            }
        }
        return null;
    }


}
