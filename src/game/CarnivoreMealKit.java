package game;

/**
 * An extended class from MealKit, which uses its implemented behaviours for the Carnivore type dinosaur
 */
public class CarnivoreMealKit extends MealKit {
    
    /**
    * A constant private and static integer cost of 500, specifies the cost of this item when purchasing from vending machine
    */
    private static final int COST = 500;


    /**
     * A Public empty Constructor, it instantiate name and display character
     */
    public CarnivoreMealKit(){
        super("CarnivoreMealKit",'ლ');
        this.addCapability(DinoCapability.FEED_CARNIVORE);
    }

    /**
     * A public getter method
     * @return : the cost
     */
    @Override
    public int getCost() {
        return COST;
    }



}
