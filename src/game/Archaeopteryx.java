package game;

/**
 * Archaeopteryx is a subclass of Dinosaur. This dinosaur is a carnivore
 */
public class Archaeopteryx extends Dinosaur {

    /**
     * Constructor
     * @param name , a String, used to input the name of the Archaeopteryx instance
     */
    public Archaeopteryx(String name) {
        super(name, '✈', 100);
        this.addCapability(DinoCapability.IS_CARNIVORE);
    }

    /**
     * Overloaded constructor to specify gender
     * @param name , a String, used to input the name of the Archaeopteryx instance
     * @param male , specifies whether the dinosaur is a male or female
     */
    public Archaeopteryx(String name, boolean male) {
        super(name, '✈', 100);
        super.setMale(male);
        this.addCapability(DinoCapability.IS_CARNIVORE);
    }

}
