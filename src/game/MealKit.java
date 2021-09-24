package game;

/**
 * A public abstract class MealKit extended from Portable Item and implements Purchasable and Feedable
 * This is the parent class that gives an ability to be portable, purchasable and feedable
 */
public abstract class MealKit extends PortableItem implements Purchasable, Feedable {

    /**
     * A constant private and static integer ADD_FOOD of 100, specifies the amount of food to be added to an actor upon consumption
     */
    private static final int ADD_FOOD = 100;
    /**
     * A constant private and static integer addEco of 50, specifies the amount of eco a player should gain when fed to a dinosaur
     */
    private static final int ADD_ECO = 50; 

    /**
     * A protected constructor
     * @param name
     * @type String
     * @param displayChar
     * @type char
     */
    protected MealKit(String name, char displayChar){
        super(name ,displayChar);
    }


    /**
     * A public getter method
     * @return : the added food
     */
    @Override
    public int foodToConsume() {
  
        return ADD_FOOD;
    }

    /**
     * A public getter method
     * @return : the added eco points
     */
    @Override
    public int getAddEco() {

        return ADD_ECO;
    }

}
