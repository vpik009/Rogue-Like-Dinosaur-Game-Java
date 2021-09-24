package game;

/**
 * Agilisaurus is a subclass of Dinosaur. This dinosaur is a Omnivore
 */
public class Agilisaurus extends Dinosaur {

    /**
     * Constructor
     * @param name , a String, used to input the name of the Agilisaurus instance
     */
    public Agilisaurus(String name) {
        super(name, '♘', 100);
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.IS_CARNIVORE);

    }

    /**
     * Overloaded constructor to specify gender
     * @param name , a String, used to input the name of the Agilisaurus instance
     * @param male , specifies whether the dinosaur is a male or female
     */
    public Agilisaurus(String name, boolean male) {
        super(name, '♘', 100);
        super.setMale(male);
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.IS_CARNIVORE);
    }


}
