package edu.interfaces;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {
    public void setPregnant(boolean bool);
    public boolean getPregnant();
    public boolean getMale();
    public int getFoodLevel();
    public void setFoodLevel(int food);
    public void addFood(int food);
    public void addThirst(int thirst);
    public int getThirst();
}
