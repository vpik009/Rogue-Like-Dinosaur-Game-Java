package game;

/**
 *A class which holds all the capabilities
 */
public enum DinoCapability {
    /**
     * Used for items/ground that a herbivore can eat by themselves without being fed
     */
    EAT_BY_SELF_HERBIVORE,
    /**
     * Used for items/ground that a carnivore can eat by themselves without being fed
     */
    EAT_BY_SELF_CARNIVORE,
     /**
     * Used for items/ground and ground types that a dinosaur can drink by themselves on play turn
     */
    DRINK_BY_SELF,
    /**
     * Used for items that can be fed to a carnivore
     */
    FEED_CARNIVORE,
    /**
     * Used for items that can be fed to a herbivore
     */
    FEED_HERBIVORE,

    /**
     * Used to specify that an actor is a Carnivore
     */
    IS_CARNIVORE,

    /**
     * Used to sepcify that the actor is a herbivore
     */
    IS_HERBIVORE;
}
