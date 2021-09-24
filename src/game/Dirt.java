package game;

import edu.monash.fit2099.engine.*;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	/**
	 * private static and constant attribute of type integer. The amount of food to add if an instance of this class were to be eaten by an actor
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * A Public empty Constructor, it instantiate the display character of the dirt
	 */
	public Dirt() {
		super('.');
	}

	/**
	 * This is a public void method that loops through the exits in its locations to generate grass if the ground type nearby allows it to
	 * @param location : The location of the Ground
	 */
	@Override
	public void tick(Location location) {
					int grassCounter = 0;
					double random = Math.random()*99+1;
					int chanceToGrowNextToTree = 2;
					int chanceToGrowNextToGrass = 10;
					boolean grassGrew = false;
					
					for (Exit exit : location.getExits()) {
						Location destination = exit.getDestination();

						if(destination.getGround() instanceof Grass) {
							grassCounter++;

							if(grassCounter>=2 && random<=chanceToGrowNextToGrass) {

								Ground grass = new Grass();
								location.setGround(grass);
								grassGrew = true;

							}

						}
						else if((destination.getGround() instanceof Tree)&&(random<=chanceToGrowNextToTree)) {
							Ground grass = new Grass();
					location.setGround(grass);
					grassGrew = true;
					
			}

			//adding eco points to the player
			for (int i = 0; i < location.map().getXRange().max() && grassGrew; i++)
			{
				for (int j = 0; j < location.map().getYRange().max(); j++)
				{
					GameMap map = location.map();
					Actor actor = map.at(i,j).getActor();

					if(actor instanceof Player)
					{
						((Player) actor).addEco(1);
					}
				}
			}
			//___________________________

		}
		
	}

	/**
	 * A public getter method
	 * @return ADD_FOOD
	 */
		@Override
		public int foodToConsume() {
			return ADD_FOOD;
		}
	

	
	}

