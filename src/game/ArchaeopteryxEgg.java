package game;
/**
 * ArchaeopteryxEgg is a type of egg that hatches into BabyArchaeopteryx.
 * Subclass of Egg, cannot be eaten by carnivores.(Otherwise Archaeopteryx would eat their own eggs)
 */
public class ArchaeopteryxEgg extends Egg {

    /**
     * A private constant and static attribute of HATCH_ECO, used to get the amount of eco a player should get when the egg hatches.
     */
    private static final int HATCH_ECO = 1000;

    /**
     * private constant and static integer attribute to provide the COST of the egg when purchasing from the vending machine
     */
    private static final int COST = 600;

    /**
     * Empty Constructor, passes hard-coded values into the super constructor to ensure
     * all instances of this class have the same name and display character
     */
    public ArchaeopteryxEgg(){
        super("Archaeopteryx Egg", '❋');
    }

    @Override
    /**
     * a public method to get the hatchEco of this instance. Classes outside of this package do no need to use this method
     * @return integer, this instance's HATCH_ECO
     */
    public int getAddEco() {
        return HATCH_ECO;
    }

    @Override
    /**
     * a public method from purchasable interface. Used as a getter to get the privat attribute cost of this instance
     * @return COST
     */
    public int getCost() {
        return COST;
    }
}
