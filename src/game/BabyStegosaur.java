package game;


/**
 * A baby dinosaur that will grow into a Stegosaur. A subclass of BabyDinosaur.
 */
public class BabyStegosaur extends BabyDinosaur {

    /**
     * Empty constructor used to instantiate objects from this class
     * Passes hard coded values into super constructor to ensure all instances of this class have the same name and display character
     */
    public BabyStegosaur(){
        super("BabyStegosaur", '✦');
        this.addCapability(DinoCapability.IS_HERBIVORE);
    }

  
    
}
