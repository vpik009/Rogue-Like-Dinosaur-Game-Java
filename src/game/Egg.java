package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * This is a public abstract Egg that extends from portableItem and implements Feedable and Purchasable
 */
public abstract class Egg extends PortableItem implements Feedable, Purchasable {

    /**
     * A private integer hatchTime of 0. Used to count the age of the egg
     */
    private int hatchTime =0;

    /**
     * A private constant and static integer TIME_TO_HATCH of 30. Used to specify how many turns it takes for an egg to hatch
     */
    private static final int TIME_TO_HATCH = 30;

    /**
     * A private constant and static integer addFood of 10, specifies how much food to add to an actor upon consumption
     */
    private static final int ADD_FOOD = 10;


    /***
     * A public constructor Egg that adds a capacity EAT_BY_SELF_CARNIVORE from dinoCapability
     * so that eggs can be fed by carnivores
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     *
     */
    protected Egg(String name, char displayChar) {
        super(name, displayChar);
    }


    /**
     * Make a use of public void tick method to increment hatch time and and if harch time is reached
     * and currentLocation does not contain an actor then we hatch an egg at the current location
     * @param currentLocation The location of the Ground
     * @type Location
     */
    @Override
    public void tick(Location currentLocation) {
        incrementHatchTime();
        //hatch
        if(hatchTime>=TIME_TO_HATCH && !currentLocation.containsAnActor()){
            hatch(currentLocation);
        }
    }


    /**
     * A public void method that increments hatch time
     */
    public void incrementHatchTime(){
        this.hatchTime++;
    }

    /**
     * A private void hatch method that removes an egg and replace the egg with a babyDinosaur
     * once it is hatched and add eco points to the player.
     * @param currentLocation
     * @type Location
     */
    private void hatch(Location currentLocation){
        currentLocation.removeItem(this); 

        if(this instanceof AllosaurEgg){
            currentLocation.addActor(new BabyAllosaur());
        }
        else if (this instanceof StegosaurEgg){
            currentLocation.addActor(new BabyStegosaur());
        }
        else if (this instanceof AgilisaurusEgg){
            currentLocation.addActor(new BabyAgilisaurus());
        }
         else if (this instanceof ArchaeopteryxEgg){
             currentLocation.addActor(new BabyArchaeopteryx());
         }


        for (int i = 0; i < currentLocation.map().getXRange().max(); i++) {
            for (int j = 0; j < currentLocation.map().getYRange().max(); j++) {
                GameMap map = currentLocation.map();

                if (map.at(i, j).getActor() instanceof Player) {
                    Actor actor = map.at(i, j).getActor();
                    ((Player) actor).addEco(this.getAddEco()); 
                }


            }
        }
    }


    /**
     * A public int getter that returns ADD_FOOD
     * @return ADD_FOOD
     */
    @Override
    public int foodToConsume() {
        return ADD_FOOD;
    }



    
}
