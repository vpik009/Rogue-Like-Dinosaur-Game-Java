package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {

	
    /**
     * private constant integer attribute to specify how many food points and actor should gain when the item is eaten
     */
	private final int addFood = 0;

	/**
	 * Public constructor to create instances of this class
	 * @param name , a string parameter to specify the name of the item
	 * @param displayChar , a character to be used to display this item on the map
	 */
	public PortableItem(String name, char displayChar) {
		super(name, displayChar, true);
	}

	@Override
	  /**
     * Public method that return the addFood attribute of this instance
     * Implemented from ItemInterfaces
	 * @return addFood
     */
	public int foodToConsume() {
		return this.addFood;
	}
}
