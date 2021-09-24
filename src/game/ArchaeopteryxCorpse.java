package game;

/**
 * A subclass of Corpse, used to spawn corpses of Archaeopteryx dinosaur types.
 */
public class ArchaeopteryxCorpse extends DinosaurCorpse{

    /**
     * Empty Constructor to instantiate objects of this class
     */
    public ArchaeopteryxCorpse() {
        super("Archaeopteryx Corpse", '≠');
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
