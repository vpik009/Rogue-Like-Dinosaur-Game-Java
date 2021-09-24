package game;
/**
 * HerbivoreMealKit extends MealKit as a portable item that carnivores can be fed
 */
public class HerbivoreMealKit extends MealKit{

    /**
     * A constant private and static integer cost of 100, specifies the cost of this item when purchasing from vending machine
     */
    private static final int COST = 100;



    /**
     * A public constructor that creates its name and displayChar
     */
    public HerbivoreMealKit(){
        super("HerbivoreMealKit",'ღ');
        this.addCapability(DinoCapability.FEED_HERBIVORE);
    }

    /**
     * A public int getter that returns cost
     *
     */
    @Override
    public int getCost() {   
        return COST;
    }


}
