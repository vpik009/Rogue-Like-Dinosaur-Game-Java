package game;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;

/**
 * This is a public class that extends MenuError.
 * It is used to create a game option for a user and allow them to choose
 * different game style.
 */
public class MainMenu extends MenuError{

    /**
     * A private int attribute for an input of eco points
     */
    private int ecoInput;

    /**
     * A private int attribute for an input of a number of turns
     */
    private int turnInput;

    /**
     * A private int boolean for sandbox
     */
    private boolean sandBox;

    /**
     * An instance of Display class
     */
    private Display display = new Display();

    /**
     * A Scanner class to read a key
     */
    private Scanner key = new Scanner(System.in);





    /**
     * A public string class that prints out a main menu and read a key
     * entered by a user.
     */
    public String drawMenu(){
        display.println(
            "\n\n____M A I N -- M E N U____\n\n"+
            "Please select one of the following option numbers:\n"+
			"1. SandBox\n"+
			"2. Challenge\n"+
			"3. Quit"
            );
            return key.nextLine();
    }

    /**
     * A public string class that controls the game style - sandbox or challenging type.
     * @param character A character to read from the main menu
     * It throws a RuntimeError or MenuError if a user enters 3 or different input other than 1,2, or 3.
     * Otherwise, for challenging, it asks for turns and eco points while it turns the sandbox mode on for sandbox.
     */
    public void optionRegister(String character){

        if (character.equals("1")){
            this.sandBox = true;
        }
        else if (character.equals("2")){
            this.sandBox = false;
            //request to enter the amount of eco points and number of turns
            while (true){
                try{
                    display.println("How many turns to play against?: ");
                    int maxTurns = Integer.parseInt(key.nextLine());
                    display.println("How many eco points are you trying to get?: ");
                    int maxEco = Integer.parseInt(key.nextLine());
                    this.turnInput = maxTurns;
                    this.ecoInput = maxEco;
                    break;
                } catch (Exception e){
                    display.println("Incorrect input please try again.");
                }
            }
        }

        else if (character.equals("3")){
            throw new RuntimeErrorException(null, "Player quits the game");
        }
        else{
            throw new MenuError();
        }

    }

    /**
     * A public int getter to get the number of turns entered by a user
     */
    public int getTurnInput(){
        return this.turnInput;
    }

    /**
     * A public int getter to get the amount of eco points entered by a user
     */
    public int getEcoInput(){
        return this.ecoInput;
    }


    /**
     * A public boolean to get the status of sandbox mode whether it is true or not.
     */
    public boolean getSandbox(){
        return this.sandBox;
    }
    
}
