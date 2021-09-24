package game;

/**
 * AgilisaurusEgg is a type of egg that hatches into BabyAgilisaurus.
 * Subclass of Egg, can eaten by carnivores.
 */
public class AgilisaurusEgg extends Egg {

    /**
     * A private constant and static attribute of HATCH_ECO, used to get the amount of eco a player should get when the egg hatches.
     */
    private static final int HATCH_ECO = 300;

    /**
     * private constant and static integer attribute to provide the COST of the egg when purchasing from the vending machine
     */
    private static final int COST = 500;

    /**
     * Empty Constructor, passes hard-coded values into the super constructor to ensure
     * all instances of this class have the same name and display character.
     * Also, it ensures that all instances of this class have the same DinoCapability so that it can be
     * eaten by Allosaurs dinosaur type.
     */
    public AgilisaurusEgg() {
        super("Agilisaurus Egg", 'Ω');
        this.addCapability(DinoCapability.EAT_BY_SELF_CARNIVORE);
        this.addCapability(DinoCapability.FEED_CARNIVORE);

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
