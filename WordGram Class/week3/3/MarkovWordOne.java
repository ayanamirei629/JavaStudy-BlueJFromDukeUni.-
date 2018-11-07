
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private HashMap<String,ArrayList<String>> hm;
    private int indexOf(String[] words, String target, int start ){
        for(int i=start; i < words.length; i++){
            if(words[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
    
    public void testIndexOf(){
        String s = "this is just a test yes this is a simple test";
        String[] sl = s.split("\\s+");
        System.out.println(indexOf(sl,"this",0));
        System.out.println(indexOf(sl,"this",3));
        System.out.println(indexOf(sl,"frog",0));
        System.out.println(indexOf(sl,"simple",2));
        System.out.println(indexOf(sl,"text",5));
    }
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        buildMap();
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }
        return sb.toString().trim();
    }
    
    public void buildMap(){
        HashMap<String,ArrayList<String>> temp = new HashMap<String,ArrayList<String>> ();
        for(int k=0; k < myText.length - 1; k++){
            String key = myText[k];
            if(!temp.containsKey(key)){
                if(k + 1 < myText.length){
                    ArrayList<String> al = new ArrayList<String>(); 
                    al.add(myText[k+1]);
                    temp.put(key,al);
                }
                // else{
                    // ArrayList<String> al = new ArrayList<String>(); 
                    // temp.put(key,al);
                // }
            }
            // if(temp == null){
                // ArrayList<String> al = new ArrayList<String>();
                // al.add(myText.substring(k + key.length(),k+key.length()+1));
                // temp.put(key,al);
            // }
            else{
                //if(k + key.length() < myText.length()){
                    ArrayList<String> al = temp.get(key);
                    al.add(myText[k+1]);
                    temp.put(key,al);
                //}
            }
        }
        hm = temp;
    }
    private ArrayList<String> getFollows(String key) {
        return hm.get(key);
    }

}
