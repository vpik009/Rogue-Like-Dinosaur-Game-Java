package game;


/**
 * DinosausCorpse is an abstract class that holds common behaviours and attributes for its subclasses
 */
public abstract class DinosaurCorpse extends PortableItem implements Feedable{

     /**
     * private static and constant integer attribute to specify how many food points and actor should gain when the item is eaten
     */
    protected static final int ADD_FOOD = 50;

    /**
     * private static and constant integer attribute to specify how many eco points to add upon feeding to a dinosaur
     */
    protected static final int ADD_ECO = 50;

    /**
     * A protected constructor
     * @param name
     * @param c
     */
    protected DinosaurCorpse(String name, char c) {
        super(name, c);
        this.addCapability(DinoCapability.EAT_BY_SELF_CARNIVORE);
        this.addCapability(DinoCapability.FEED_CARNIVORE); 
    }


}
