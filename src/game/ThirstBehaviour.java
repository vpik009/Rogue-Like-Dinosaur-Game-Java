package game;

import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * ThirstBehaviour class implements Behaviour interface, and hence implements the getAction method
 * This class is used for dinosaurs to allow them to go towards water source if its thirst level is under 50
 * It should go towards the pool and raise DrinkAction to drink water.
 */
public class ThirstBehaviour implements Behaviour {

    @Override
    /**
     * Get the suitable action based on the distance between the actor and water location.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return DrinkAction if the actor is right next to the water source. If the distance is far, it should
     * move towards the water source, or else it should return WanderBehaviour.
     */
    public Action getAction(Actor actor, GameMap map) {

        List<Exit> exits = map.locationOf(actor).getExits();
        Location here = map.locationOf(actor);

        Location waterLocation = getWater(actor, map);

        if (waterLocation == null || (actor instanceof Dinosaur && ((Dinosaur)actor).getThirst() >50) ){
         return null;
        }

        if(distance(here, waterLocation) > 1) {
            Location closest = null;
            Exit exitTo = null;

            for (Exit exit : here.getExits()) {

                if ( closest == null || (distance(exit.getDestination(), waterLocation) < distance(closest, waterLocation))) {
                    closest = exit.getDestination();
                    exitTo = exit;
                }
            }
            if(!exitTo.getDestination().containsAnActor())
                return new MoveActorAction(closest, exitTo.getName());
            else
                return new WanderBehaviour().getAction(actor, map);


        } else if (distance(here, waterLocation) == 1) {
            return new DrinkAction(waterLocation);
            // refactor later
        }

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
     * private method used to get the closest water Source. It loops through the map to find a water source. Then,
     * it compares the distance of all the water sources from the actor location to check which is the closest from
     * the actor.
     * @param actor , the actor who is looking for a partner to mate with
     * @param map , the map the actor is on
     * @return closestWater or if closestWater does not exist then return null.
     */
    private Location getWater(Actor actor, GameMap map){
        Location currentWater = null;
        Location closestWater = null;
        Location here = map.locationOf(actor);
        int iter = 0;
        for (int i = 0; i < map.getXRange().max() ; i++) {
            for (int j = 0; j < map.getYRange().max(); j++)
            {
                if((map.at(i,j).getGround() instanceof Water))
                {
                    currentWater = map.at(i,j);
                    if(iter == 0){
                        closestWater = currentWater;
                    }

                    if(distance(here, currentWater) < distance(here, closestWater)) {
                        closestWater = currentWater;
                    }


                    iter++;
                }
            }
        }
        if(closestWater == null){
            return null;
        } else {
            return closestWater;
        }
    }

}
