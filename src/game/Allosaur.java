package game;

import edu.engine.Action;
import edu.engine.Actions;
import edu.engine.Actor;
import edu.engine.Display;
import edu.engine.DoNothingAction;
import edu.engine.GameMap;


/**
 * Allosaur is a subclass of Dinosaur. This dinosaur is a Carnivore
 */
public class Allosaur extends Dinosaur {


	/**
	 * Constructor
	 * @param name , a String, used to input the name of the Allosaur instance
	 */
	public Allosaur(String name) {
		super(name, 'a', 100);
		this.addCapability(DinoCapability.IS_CARNIVORE);
	}

	/**
	 * Overloaded constructor to specify gender
	 * @param name , a String, used to input the name of the Allosaur instance
	 * @param male , specifies whether the dinosaur is a male or female
	 */
	public Allosaur(String name, boolean male) {
		super(name, 'a', 100);
		super.setMale(male);
		this.addCapability(DinoCapability.IS_CARNIVORE);
	}


}

