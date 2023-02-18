package game;

import edu.engine.WeaponItem;

/**
 * A public class LaserGun extended from WeapanItem that implements Purchasable
 * determines its cost and damage
 */
public class LaserGun extends WeaponItem implements Purchasable{

    /**
     * private constant integer attribute to specify how many food points and actor should gain when the item is eaten
     */
    private static final int ADD_FOOD = 0;

    /**
     * A private static and constant integer COST of 500, specifies how much the item costs if bought from a vending machine
     */
    private static final int COST = 500;

    /**
     * A public constructor that adds its name, displayChar, damage, and verb
     */
    public LaserGun(){
        super("Laser Gun", '➳', 100, "blasts");
    }

    /**
     * A public int method getCost that returns cost
     * @return COST
     */
    public int getCost(){
        return COST;
    }

    @Override
    /**
     * Public method that return the addFood attribute of this instance
     * Implemented from ItemInterfaces
     * @return ADD_FOOD
     */
    public int foodToConsume() {
        return ADD_FOOD;
    }

}
