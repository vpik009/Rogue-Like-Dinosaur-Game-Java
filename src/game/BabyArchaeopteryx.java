package game;

/**
 * A baby dinosaur that will grow into an Archaeopteryx. A subclass of BabyDinosaur.
 */
public class BabyArchaeopteryx extends BabyDinosaur {

    /**
     * Empty Constructor used to create instances of this class.
     * Provides hard coded values to super constructor to ensure the same name
     * and display character for all the instances of this class.
     */
    protected BabyArchaeopteryx() {
        super("BabyArchaeopteryx", '★');
        this.addCapability(DinoCapability.IS_CARNIVORE);
    }
    
}
