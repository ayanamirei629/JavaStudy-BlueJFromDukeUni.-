
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    protected ArrayList<String> getFollows(String key){
        ArrayList<String> al = new ArrayList<String>();
        for(int i=0; i < myText.length() - key.length(); i++){
           if(myText.substring(i, i + key.length()).equals(key)){
               if(i + key.length() < myText.length()){
                   al.add(myText.substring(i + key.length(),i+key.length()+1));
                }
           }
        }
        return al;
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

}
