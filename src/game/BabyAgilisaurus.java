package game;

/**
 * A baby dinosaur that will grow into an Agilisaurus. A subclass of BabyDinosaur.
 */
public class BabyAgilisaurus extends BabyDinosaur {

    /**
     * Empty Constructor used to create instances of this class.
     * Provides hard coded values to super constructor to ensure the same name
     * and display character for all the instances of this class.
     */
    public BabyAgilisaurus() {
        super("BabyAgilisaurus", 'Σ');
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.IS_CARNIVORE);
    }
}
