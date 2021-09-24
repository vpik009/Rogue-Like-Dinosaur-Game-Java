package game;

/**
 * A subclass of Corpse, used to spawn corpses of agilisaurus dinosaur types.
 */
public class AgilisaurusCorpse extends DinosaurCorpse{

    /**
     * private static and constant integer attribute to specify how many food points and actor should gain when the item is eaten
     * overrides that of the corpse class
     */
    private final static int ADD_FOOD = 20;

    /**
     * Empty Constructor to instantiate objects of this class
     */
    public AgilisaurusCorpse() {
        super("Agilisaurus Corpse", 'β');
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
