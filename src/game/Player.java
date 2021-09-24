package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	/**
	 * private attribute integer eco
	 */
	private int eco = 0;

	/**
	 * private integer varible of thirst that represent the player instance's thirst level
	 */
	private int thirst = 50;

	/**
	 * private attribute boolean male that randomises the chance of being male or female
	 */
	private boolean male = (Math.random() < 0.5);

	/**
	 * private attribute boolean pregnant
	 */
	private boolean pregnant = false;

	/**
	 * private attribute integer foodLevel
	 */
	private int foodLevel = 50;

	/**
	 * private call of Manu Class
	 */
	private Menu menu = new Menu();


	
	/**
	 * tells whether or not the player has picked sandbox or challenge game mode
	 */
	private boolean sandBox = true;


	/**
	 * A private integer attribute that is used to count the number of turns
	 */
	private int turnCounter = 0;

	/**
	 * A private integer attribute that determines the goal turns
	 */
	private int goalTurns;

	/**
	 * A private integer attribute that counts an amount of eco points needed for a goal.
	 */
	private int goalEco;



	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}


	/**
	 * Select and return an action to perform on the current turn.
	 * If the player is at the top north of the original map, it will allow an actor to teleport to the second map.
	 * Also, if the player is at the bottom south of the original map, it will allow an actor to move back to the original map.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		
		//check game mode and status of the player

		if(!sandBox){
			if (getEco()>= goalEco ){
	
				display.println("WOWAWIWA YOU WIN!");
				throw new QuitToMenuError();
			}
			else if (getEco()< goalEco && turnCounter>=goalTurns ){
				display.println("HAHA LOSER! YOU LOSE!");
				throw new QuitToMenuError();
			}

		}
		turnCounter++;


		//CollectGrass
		if(map.locationOf(this).getGround() instanceof Grass){
			actions.add(new CollectGrassAction(map.locationOf(this)));
		}
		//PickFruit
		if(map.locationOf(this).getGround() instanceof Tree){
			actions.add(new PickFruitAction(map.locationOf(this)));
		}
		//Ability to quit
		actions.add(new QuitAction());


		//to the second map from the first map
		//compare with min value since travel only from the north of the map
		if(Application.getMapCollection().get(0).locationOf(this).y()==Application.getMapCollection().get(1).getYRange().min() && Application.getMapCollection().get(0).contains(this))
		{
			int playerX = map.locationOf(this).x();
			int mapMaxY = map.getYRange().max();
			actions.add(new MoveActorAction(Application.getMapCollection().get(1).at(playerX, mapMaxY), " to the second map!"));
		}

		//To the first map from the second map
		//compare with max value since travel only from the south of the map
		if(Application.getMapCollection().get(1).locationOf(this).y()==Application.getMapCollection().get(1).getYRange().max() && Application.getMapCollection().get(1).contains(this))
		{
			int playerXLocation = map.locationOf(this).x();
			int mapMinY = map.getYRange().min();
			actions.add(new MoveActorAction(Application.getMapCollection().get(0).at(playerXLocation, mapMinY), " back to the original map!"));
		}

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();



		display.println(this + " has "+getEco() + " eco points");
		return menu.showMenu(this, actions, display);

	}

	/**
	 * public void method addEco
	 * @param eco
	 * @type int
	 * @return added eco points
	 */
	public void addEco(int eco) {
		this.eco += eco;
	}

	/**
	 * public int method getEco is a getter
	 * @return eco
	 */
	public int getEco() {
		return this.eco;
	}

	/**
	 * a setter for pregnant
	 * @return pregnant in boolean
	 */
	@Override
	public void setPregnant(boolean bool) {
		this.pregnant = bool;
	}

	/**
	 * a getter for male
	 * @return male
	 */
	@Override
	public boolean getMale() {
		return this.male;
	}

	/**
	 * a getter for pregnant
	 * @return pregnant
	 */
	@Override
	public boolean getPregnant() {
		return this.pregnant;
	}

	/**
	 * a getter for FoodLevel in integer type
	 * @return foodLevel
	 */
	@Override
	public int getFoodLevel() {
		return this.foodLevel;
	}

	/**
	 * a setter for FoodLevel in integer type
	 * @param food
	 * @type int
	 * @return foodLevel
	 */
	@Override
	public void setFoodLevel(int food) {
		this.foodLevel = food;
	}

	/**
	 * a public void method that adds on to the food level
	 * @param food
	 * @type int
	 * @return foodLevel
	 */
	@Override
	public void addFood(int food) {
		if (food>=100){
			this.foodLevel = 100;
		}
		else{
			this.foodLevel = food;
		}

	}

	@Override
	/**
	 * a public void method that adds on to the thirst value
	 * @param thirst
	 * @type int
	 * @return thirst
	 */
	public void addThirst(int thirst) {
		if (this.thirst+thirst > 100){
            this.thirst = 100;
        }
        else{
        this.thirst += thirst;
        }

	}

	@Override
	/**
	 * a getter for thirst in integer type
	 * @return foodLevel
	 */
	public int getThirst() {
		return this.thirst;
	}

	/**
	 * a getter to get the boolean of sandBox
	 * @return sandBox
	 */
	public boolean getSandBox(){
		return this.sandBox;
	}

	/**
	 * a setter for sandBox
	 * @param bool to set the mode for sandbox - true or false
	 */
	public void setSandBox(boolean bool){
		this.sandBox = bool;
	}

	/**
	 * a setter for number of turns player can move in the challenge mode
	 * @param maxTurns to set the maximum number of turns
	 */
	public void setGoalTurns(int maxTurns){
		this.goalTurns = maxTurns;
	}

	/**
	 * a setter for an amount of eco points to set for players to obtain to accomplish the
	 * challenging mode.
	 * @param maxEco to set the maximum amount of eco points
	 */
	public void setGoalEco(int maxEco){
		this.goalEco = maxEco;
	}

}
