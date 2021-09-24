package game;

import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;

/**
 * Public Application class that displays a map and respawning all the necessary
 * ground types and actors on a selected map, then the world runs to initiate a game.
 */
public class Application {

	/**
	 * private static final variable MapCollection is used to store maps in the array list
	 */
	private static final ArrayList<GameMap> MapCollection = new ArrayList<GameMap>();


	/**
	 * main method that runs the program
	 */
	public static void main(String[] args) {

		/**
		 * An instance of MainMenu Class
		 */
		//Main menu (choose a game mode)
		MainMenu mainMenu = new MainMenu();

		/**
		 * An instance of Display Class
		 */
		Display display = new Display();

		
		try{
			while (true) {
				try{
					String userInput = mainMenu.drawMenu();
					mainMenu.optionRegister(userInput);
					int eco = mainMenu.getEcoInput();
					int turns = mainMenu.getTurnInput();
					boolean sandBox = mainMenu.getSandbox();
					World world = setWorld(display, eco, turns, sandBox);
					world.run();
					break;
				}
				catch (MenuError e){
					display.println("\nIncorrect input. Please try again.\n");
				}
				catch(QuitToMenuError qtm){
					display.println("\nYou have returned back to the main menu screen\n");
				}
			}
			
		}
		catch(Exception e){
			display.println("You have quit the game");
		}
		
	}

	/**
	 * private static void method that generates a grass on the ground if the ground type is dirt.
	 * @param gameMap the map to generate the grass
	 */
	private static void generateGrass(GameMap gameMap){
		for (int i =0; i<gameMap.getXRange().max();i++) {
			for (int j = 0; j<gameMap.getYRange().max();j++) {
				if(gameMap.at(i,j).getGround() instanceof Dirt) {
					double random = Math.random() * 100;
					if(random<=2)
						gameMap.at(i,j).setGround(new Grass());
				}
							
			}
		}
	}

	/**
	 * private static void method that add a map to the array list
	 */
	public static void addMapCollection(GameMap map) {
		MapCollection.add(map);
	}

	/**
	 * private static method that get the arraylist of maps
	 */
	public static ArrayList<GameMap> getMapCollection() {
		return MapCollection;
	}

	/**
	 * private static method that sets a world.
	 * @param display is used to display world
	 * @param eco is used to set the amount of eco points to obtain for challenging mode
	 * @param turns is used to set the number of turns for challenging mode
	 * @param sandBox is used to determine whether or not the game mode is sandBox
	 * @return world
	 */
	private static World setWorld(Display display, int eco, int turns, boolean sandBox){

		//create new world
		World world = new World(display);
		//added water to be able use fancy ground factory
		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Water());
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######..................~~~~~~~~~~~~~~~~~~~...............................",
		".....#_____#.....................~~~~~~~~~~~~...................................",
		".....#_____#.........................~~~~.......................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");

		List<String> secondMap = Arrays.asList(
		"..........................#################################################.....",
		"..........................#_______________________________________________#.....",
		"..........................#_______________________________________________#.....",
		"..........................#_______###########___________#############_____#.....",
		"..........................#_______~~~~~~~~~~~___________~~~~~~~~~~~~~_____#.....",
		"..........................#_________~~~~~~~_______________~~~~~~~~~_______#.....",
		".......+~~~~..............#_______________________________________________#.....",
		"......++~~~~..............#################_______________#################.....",
		"......++.........................+.........._____________..........+............",
		"......++.........................+............._______.............+............",
		".......+.........................+...............___...............+............",
		".................................+.................................+............",
		".................................+.................................+............",
		".................................+.................................+............",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		".........+......................................................................",
		"........++......................................................................",
		"........++......................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"................................................................................");

		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		GameMap secondGameMap = new GameMap(groundFactory, secondMap);
		world.addGameMap(secondGameMap);

		// calling the addMapCollection method that adds a map inside an arraylist
		MapCollection.clear(); //clear all the previous maps
		Application.addMapCollection(gameMap);
		Application.addMapCollection(secondGameMap);

		Actor player = new Player("Player", '@', 100);
		((Player)player).setSandBox(sandBox);
		if(!sandBox){
			((Player)player).setGoalEco(eco);
			((Player)player).setGoalTurns(turns);
		}
		//FIRST GAME MAP
		world.addPlayer(player, gameMap.at(9, 4));

		Stegosaur s1 = new Stegosaur("Stegosaur",false);
		gameMap.at(30, 12).addActor(s1);

		Stegosaur s2 = new Stegosaur("Stegosaur",true);
		gameMap.at(42, 12).addActor(s2);


		//generate grass
		generateGrass(gameMap);
		//spawn vending machine on the first game map
		gameMap.at(12, 7).setGround(new VendingMachine());
		
		//SECOND GAME MAP
		secondGameMap.at(13,13).addActor(new Stegosaur("Stegosaur"));
		secondGameMap.at(14,13).addActor(new Stegosaur("Stegosaur"));
		secondGameMap.at(15,13).addActor(new Stegosaur("Stegosaur"));
		secondGameMap.at(16,13).addActor(new Stegosaur("Stegosaur"));

		//generate grass
		generateGrass(secondGameMap);
		//spawn vending machine on the second game map
		secondGameMap.at(13, 8).setGround(new VendingMachine());

		return world;
	}

}


