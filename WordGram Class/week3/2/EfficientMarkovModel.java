
/**
 * 在这里给出对类 EfficientMarkovModel 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.Random;
import edu.duke.*;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
    // private String myText;
    // private Random myRandom;
    private int N;
    private HashMap<String,ArrayList<String>> hm;
    public EfficientMarkovModel() {
        myRandom = new Random();
        
    }
    
    public void setN(int num){
        N = num;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public ArrayList<String> getFollows(String key){
        return hm.get(key);
    }
    
    public void buildMap(){
        if (myText == null){
            System.out.println("NO TEXT");
            return ;
        }
        HashMap<String,ArrayList<String>> temp = new HashMap<String,ArrayList<String>> ();
        // for(int k=0; k < myText.length() - N; k++){
            // String key = myText.substring(k,k+N);
            // if( temp == null || !temp.containsKey(key)){
                // ArrayList<String> al = new ArrayList<String>();
                // for(int i=0; i < myText.length() - key.length(); i++){
                    // if(myText.substring(i, i + key.length()).equals(key)){
                        // if(i + key.length() < myText.length()){
                           // al.add(myText.substring(i + key.length(),i+key.length()+1));
                        // }
                    // }
                // }
                // temp.put(key,al);
            // }
        // }
        for(int k=0; k < myText.length() - N; k++){
            String key = myText.substring(k,k+N);
            if(!temp.containsKey(key)){

                ArrayList<String> al = new ArrayList<String>(); 
                al.add(myText.substring(k + key.length(),k+key.length()+1));
                temp.put(key,al);
                
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
                    al.add(myText.substring(k + key.length(),k+key.length()+1));
                    temp.put(key,al);
                //}
            }
        }
        if(!temp.containsKey(myText.substring(myText.length() - N,myText.length()))){
            ArrayList<String> al = new ArrayList<String>(); 
            hm.put((myText.substring(myText.length() - N,myText.length())),al);
        }
        hm = temp;
        printHashMapInfo();
    }
    
    public void printHashMapInfo(){
        int max = 0;
        System.out.println("number of keys is:  " + hm.size());
        for(String s : hm.keySet()){
            //System.out.println("-----------------------");
            ArrayList<String> sl = hm.get(s);
            // if(hm.size() < 30){
                // System.out.println("The key is " + s);
                // for(String l : sl){
                    // System.out.println("The set is " + l);
                // }
            // }
            if(max < sl.size()){
                max = sl.size();
            }
        }
        
        System.out.println("max size is: " + max); 
        for(String k : hm.keySet()){
            if (hm.get(k).size() == max){
                System.out.println("max position keys is:  " + k);
            }
        }
    }
    
    public String getRandomText(int numChars){
    	if (myText == null){
    		return "";
    	}
    	buildMap();
    	StringBuilder sb = new StringBuilder();
    	int index = myRandom.nextInt(myText.length()-N);
    	String key = myText.substring(index,index+N);
    	sb.append(key);
    	for(int k=0; k < numChars - N; k++){
    		ArrayList<String> follows =getFollows(key);
    		if(follows == null){
    		    break;
    		}
    		index = myRandom.nextInt(follows.size());
    		String next = follows.get(index);
    		sb.append(next);
    		key = key.substring(1) + next;
    	}
    	return sb.toString();
    }
    
    
    public String toString(){
        return "MarkovModel of order " + N;
    }
}