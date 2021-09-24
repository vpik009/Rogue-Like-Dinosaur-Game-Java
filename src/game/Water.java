package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Water class, extended from Ground class that gives an ability for dinosaurs to drink water and
 * introduce thirst that shows how much of water a dinosaur needs in order to keep hydrated.
 */
public class Water extends Ground {

    /**
     * Public constructor used to contrust new instances
     */
    public Water() {
        super('~');
        this.addCapability(DinoCapability.DRINK_BY_SELF);
    }


	/**
	 * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
	 *
	 * @param actor the Actor to check
	 * @return false
	 */
	public boolean canActorEnter(Actor actor) {
        if(actor instanceof Archaeopteryx || actor instanceof BabyArchaeopteryx){ // this dinosaur can fly over water
            return true;
        }
        else{
            return false;
        }
	}

    /**
     * Private constant attribute of Thirst that shows the amount of water level an
     * actor gains upon consuming the ground type
     */
    private static final int THIRST = 30;

    @Override
    public int foodToConsume() {
        return THIRST;
    }
    
}
