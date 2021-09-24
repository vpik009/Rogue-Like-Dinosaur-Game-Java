package game;

/**
 * A baby dinosaur that will grow into an Allosaur. A subclass of BabyDinosaur.
 */
public class BabyAllosaur extends BabyDinosaur{
    
    /**
     * Empty Constructor used to create instances of this class.
     * Provides hard coded values to super constructor to ensure the same name
     * and display character for all the instances of this class.
     */
        public BabyAllosaur(){
            super("BabyAllosaur",'✴');
            this.addCapability(DinoCapability.IS_CARNIVORE);
        }


}
