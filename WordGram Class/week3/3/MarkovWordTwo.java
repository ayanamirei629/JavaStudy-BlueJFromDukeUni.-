
/**
 * 在这里给出对类 MarkovWordTwo 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private HashMap<ArrayList<String>,ArrayList<String>> hm;
    private int indexOf(String[] words, String target1,String target2,int start ){
        for(int i=start; i < words.length-1; i++){
            if(words[i].equals(target1) && words[i+1].equals(target2)){
                return i;
            }
        }
        return -1;
    }
    
    // public void testIndexOf(){
        // String s = "this is just a test yes this is a simple test";
        // String[] sl = s.split("\\s+");
        // System.out.println(indexOf(sl,"this","is",0));
        // System.out.println(indexOf(sl,"this","is",3));
        // System.out.println(indexOf(sl,"simple","test",2));
    // }
    public void testFellows(){
        String s = "this is just a test yes this is a simple test";
        myText = s.split("\\s+");
        buildMap();
        ArrayList<String> follows = getFollows("this","is");
        for(String k: follows){
            System.out.println(k);
        }
    }
    public MarkovWordTwo() {
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
        int index = myRandom.nextInt(myText.length-2);  // random word to start with
        String key1 = myText[index];
        String key2 = myText[index+1];
        buildMap();
        System.out.println(key1);
        System.out.println(key2);
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        for(int k=0; k < numWords-2; k++){
            ArrayList<String> follows = getFollows(key1,key2);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key1 = key2;
            key2 = next;
        }
        return sb.toString().trim();
    }
    
    public void buildMap(){
        HashMap<ArrayList<String>,ArrayList<String>> temp = new HashMap<ArrayList<String>,ArrayList<String>> ();
        for(int k=0; k < myText.length - 2; k++){
            //System.out.println(k);
            ArrayList<String> text = new ArrayList<String>();
            String key1 = myText[k];
            String key2 = myText[k+1];
            text.add(key1);
            text.add(key2);
            //conditions for the last index
            //System.out.println(k);
            if(!temp.containsKey(text)){
                if(k + 2 < myText.length){
                    ArrayList<String> al = new ArrayList<String>(); 
                    al.add(myText[k+2]);
                    temp.put(text,al);
                }
            }
            else{
                //if(k + key.length() < myText.length()){
                    ArrayList<String> al = temp.get(text);
                    al.add(myText[k+2]);
                    temp.put(text,al);
                //}
            }
        }
        hm = temp;
    }
    
    private ArrayList<String> getFollows(String key1,String key2) {
        ArrayList<String> answer = new ArrayList<String>();
        answer.add(key1);
        answer.add(key2);
        return hm.get(answer);
    }

}
