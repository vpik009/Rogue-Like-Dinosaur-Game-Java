package game;


/**
 * This is a public class StegosaurCorpse that is a child od DinosaurCorpse class
 * It gives addFood of 40 once eaten.
 */
public class StegosaurCorpse extends DinosaurCorpse {

    /**
     * A public constructor that instantiate objects of this class.
     */
    public StegosaurCorpse() {
        super("Stegosaur Corpse", '₴');
    }

    @Override
    public int getAddEco() {
        return ADD_ECO;
    }

    @Override
    public int foodToConsume() {
        return ADD_FOOD;
    }



}