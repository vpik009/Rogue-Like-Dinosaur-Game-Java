package game;




import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

/**
 * This is a public class Stegosaur, which is a child class of Dinosaur.
 */
public class Stegosaur extends Dinosaur {
	// Will need to change this to a collection if Stegosaur gets additional Behaviours.
	//	private ArrayList<Behaviour> behaviour = new ArrayList<>();; //changed to arraylist so as to be able to prioritize behaviours?

	/** 
	 * public constructor.
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 *
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name) {
		super(name, 'd', 100);
		this.addCapability(DinoCapability.IS_HERBIVORE);

	}

	/**
	 * Overloaded constructor to specify gender
	 * @param name , a String, used to input the name of the Stegosaur instance
	 * @param male , specifies whether the dinosaur is a male or female
	 */
	public Stegosaur(String name, boolean male) {
		super(name, 'd', 100);
		super.setMale(male);
		this.addCapability(DinoCapability.IS_HERBIVORE);
	}
}



