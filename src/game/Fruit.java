package game;

import edu.engine.Item;
import edu.engine.Location;

/**
 * A public class Fruit  that is extended from PortableItem that implements Purchasable and Feedable
 */
public class Fruit extends PortableItem implements Purchasable, Feedable{

	/**
	 * A private integer ROT of 0, which counts the fruits 'age': increments once per tick
	 */
	private int rot= 0;

	/**
	 * A constant private and static integer COST of 30, specifies how mmany eco points the item costs
	 */
	private static final int COST = 30;

	/**
	 * A constant private static integer ADD_FOOD of 30, specifies how much food should be added to an actor upon consumption
	 */
	private static final int ADD_FOOD =30;

	/**
	 * A private static and constant integer ADD_ECO of 15, specifies how much eco points a player should get when this item is fed to another actor
	 */
	private static final int ADD_ECO = 15;

	/**
	 * A private constant integer to specify how long it takes for the fruit to rot away
	 * all instances of fruit have this amount to rot, hence it is static
	 */
	private static final int TURNS_TO_ROT = 20;


	/**
	 * A public constructor that determines name and display character for Fruit
	 * Adds a capability EAT_BY_SELF_HERBIVORE from DinoCapability
	 */
	public Fruit() {
		super("Fruit", 'f'); //Fruit is displayed as f and is portable
		this.addCapability(DinoCapability.EAT_BY_SELF_HERBIVORE);
		this.addCapability(DinoCapability.FEED_HERBIVORE);
	}

	/**
	 * Control the time for a fruit to get rotten by using public void tick method
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		incrementRot();
		if(getRot()>=TURNS_TO_ROT) { //fruit rots away after 20 turns
			location.removeItem(this); //removes the fruit from the ground (method only runs if its on the ground)
		}
	}

	/**
	 * a public void incrementRot method that increments rot counter
	 * @return rot++
	 */
	private void incrementRot(){
		this.rot++;
	}

	/**
	 * a getter for rot
	 * @return rot
	 */
	private int getRot(){
		return this.rot;
	}

	//purchasable
	/**
	 * a getter for cost
	 * @return cost
	 */
	public int getCost(){
		return COST;
	}

	@Override
	//feedable
	/**
	 * a getter for ADD_FOOD
	 * @return ADD_FOOD
	 */
	public int foodToConsume(){
		return ADD_FOOD;
	}

	/**
	 * a getter for addEco
	 * @return addEco
	 */
	public int getAddEco(){
		return ADD_ECO;
	}

}
