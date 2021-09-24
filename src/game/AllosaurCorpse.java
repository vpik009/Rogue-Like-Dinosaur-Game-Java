package game;

/**
 * A subclass of Corpse, used to spawn corpses of allosaur dinosaur types.
 */
public class AllosaurCorpse extends DinosaurCorpse{

 

  /**
   * Empty Constructor to instantiate objects of this class
   */
    public AllosaurCorpse() {
        super("Allosaur Corpse", '₳');
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