package game;

import edu.monash.fit2099.engine.*;


/**
 * Abstract class BabyDinosaur inherits from Dinosaur used to represent baby dinosaur types. 
 * Overrides the playTurn action from dinosaur as BabyDinosaurs are not capable of doing some things adult dinosaurs do.
 * and need to constanly increment their age to allow them to grow big and strong
 */
public abstract class BabyDinosaur extends Dinosaur {

    /**
     * private integer attribute age
     * Used to calculate the age of the babydinosaur and spawn an adult dinosaur of the same dinosaur type when reaches a certain value
     */
    private int age = 0;

    /**
     * Constructor.
     *
     * @param name , the name of the BabyDinosaur Actor
     *@param displayChar , the display character of the BabyDinosaur
     */
    protected BabyDinosaur(String name,char displayChar) {
        super(name, displayChar, 100);
        //the starting food level of a baby dinosaur is 10:
        super.setFoodLevel(10);
    }


    @Override
    /**
     * Used to execute a non controlled actors turn based on their behaviours.
     * Responsible for incrementing the baby dinosaur's age and spawning an adult dinosaur of the same type when this instance is old enough
     * @see Actor#playTurn(Actions, Action, GameMap, Display)
     * @param actions
     * @param lastAction
     * @param map
     * @param display
     * @return Action that is to be executed.
     */
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display){
            //Calculate when to turn to adult
            this.incrementAge();
  

            if(super.checkStatus(display, map)!=null){
                return new DieAction();
            }

            
            if(this.getAge()>=30){
                Location thisLocation = map.locationOf(this);
                map.removeActor(this);

                if(this instanceof BabyStegosaur)
                    map.addActor(new Stegosaur("Stegosaur"),thisLocation);

                else if (this instanceof BabyAllosaur)
                    map.addActor(new Allosaur("Allosaur"),thisLocation);

                else if (this instanceof BabyArchaeopteryx)
                    map.addActor(new Archaeopteryx("Archaeopteryx"),thisLocation);

                else if (this instanceof BabyAgilisaurus)
                    map.addActor(new Agilisaurus("Agilisaurus"),thisLocation);

                return new DoNothingAction();
            }
            //return an action from its list defined in Dinosaur
  
            for (int i = 0; i < behaviour.size() && this.isConscious(); i++) { //get behaviours

               Action res = behaviour.get(i).getAction(this, map);   //return wander behaviour

                if (res != null){
                    return res;
                }

            }
    
            return new DoNothingAction();

    }
    
    /**
     * private method getAge, used to get the age of this instance
     * @return integer attribute age of this instance
     */
    private int getAge(){
        return age;
    }

    /**
     * private method incrementAge used to increment the age of this instance in the playTurn method on each turn
     */
    private void incrementAge(){
        age++;
    }
}
