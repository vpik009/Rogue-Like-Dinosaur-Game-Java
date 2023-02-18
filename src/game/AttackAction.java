package game;

import java.util.Random;

import edu.engine.Action;
import edu.engine.Actions;
import edu.engine.Actor;
import edu.engine.GameMap;
import edu.engine.Item;
import edu.engine.Weapon;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;
	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 */
	public AttackAction(Actor target) {
		this.target = target;
	}

	@Override
	/**
	 * Used to execute the action. Provides all the behaviours that should happen once this behaviour is executed
	 * @param actor , which actor is performing this action.
	 * @param map , the map instance on which the actor exists.
	 * @see Action#execute(Actor, GameMap)
	 */
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (rand.nextBoolean()) {
			return actor + " at [" + map.locationOf(actor).x() + "]["+map.locationOf(actor).y() +"] " + " misses " + target + " at [" +map.locationOf(target).x() + "]["+map.locationOf(target).y()+ "].";
		}

		int damage = weapon.damage();
		String result = actor + " at [" + map.locationOf(actor).x() + "]["+map.locationOf(actor).y() +"] " + weapon.verb() + " " + target + " at [" +map.locationOf(target).x() + "]["+map.locationOf(target).y()+ "] for " + damage + " damage.";

		target.hurt(damage);
		if (!target.isConscious()) {
			DinosaurCorpse corpse;
			if(target instanceof Stegosaur || target instanceof BabyStegosaur){
				corpse = new StegosaurCorpse();
			}

			else if(target instanceof Allosaur || target instanceof BabyAllosaur){
				corpse = new AllosaurCorpse();
			}

			else if(target instanceof Agilisaurus || target instanceof BabyAgilisaurus) {
				corpse = new AgilisaurusCorpse();
			}

			else {
				corpse = new ArchaeopteryxCorpse();
			}

			map.locationOf(target).addItem(corpse);
			
			Actions dropActions = new Actions();
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction());
			for (Action drop : dropActions)		
				drop.execute(target, map);
			map.removeActor(target);	
			
			result += System.lineSeparator();
		}

		return result;
	}

	@Override
	/**
	 * Menu description is a method  that displays a message on the menu when the action is able to be performed
	 * @param actor , the actor that is performing this action
	 * @see Action#menuDescription(Actor)
	 */
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}


}
