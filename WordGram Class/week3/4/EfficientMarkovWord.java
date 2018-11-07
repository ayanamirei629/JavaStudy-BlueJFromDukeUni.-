
/**
 * 在这里给出对类 EfficientMarkovWord 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class EfficientMarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<Integer,WordGram> dict;
    private HashMap<Integer,ArrayList<String>> hm;
    private int indexOf(String[] words, WordGram target, int start ){
        for(int i=start; i < words.length - myOrder +1; i++){
            WordGram wg = new WordGram(words,i,myOrder);
            if(wg.equals(target)){
                return i;
            }
        }
        return -1;
    }

    
    
    // public void testIndexOf(){
        // String s = "this is just a test yes this is a simple test";
        // String[] sl = s.split("\\s+");
        // WordGram wg = new WordGram(sl,2,4);
        // WordGram w = new WordGram(sl,0,4);
        // System.out.println(indexOf(sl,wg,0));
        // System.out.println(indexOf(sl,wg,5));
        // System.out.println(indexOf(sl,w,0));
        // System.out.println(indexOf(sl,w,2));
    // }
    
    public EfficientMarkovWord(int Num) {
        myRandom = new Random();
        myOrder = Num;
    }
    
    public void setN(int Num){
        myOrder = Num;
    }
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public ArrayList<String> getFollows(WordGram kGram){
        // ArrayList<String> al = new ArrayList<String>();
        // for(int i=0; i<myText.length - myOrder; i++){
            // WordGram wg = new WordGram(myText,i,myOrder);
            // if(wg.equals(kGram)){
                // al.add(myText[i+myOrder]);
            // }
        // }
        // return al;
        return hm.get(kGram.hashCode());
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        WordGram wg = new WordGram(myText,index,myOrder);
        sb.append(wg);
        sb.append(" ");
        //System.out.println(wg);
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(wg);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            //System.out.println(next);
            sb.append(next);
            sb.append(" ");
            wg = wg.shiftAdd(next);
            //System.out.println(wg);
        }
        return sb.toString().trim();
    }
    
    public void buildMap(){
        HashMap<Integer,WordGram> ident = new HashMap<Integer,WordGram> ();
        HashMap<Integer,ArrayList<String>> temp = new HashMap<Integer,ArrayList<String>> ();
        for(int k=0; k < myText.length - myOrder; k++){
            WordGram wg = new WordGram(myText,k,myOrder);
            if(!temp.containsKey(wg.hashCode())){
                ArrayList<String> al = new ArrayList<String>();
                al.add(myText[k+myOrder]);
                temp.put(wg.hashCode(),al);
                ident.put(wg.hashCode(),wg);
            }
            else{
                ArrayList<String> al = temp.get(wg.hashCode());
                al.add(myText[k+myOrder]);
                temp.put(wg.hashCode(),al);
            }
        }
        WordGram wg = new WordGram(myText,myText.length - myOrder,myOrder);
        if(!temp.containsKey(wg.hashCode())){
            ArrayList<String> al = new ArrayList<String>();
            temp.put(wg.hashCode(),al);
            ident.put(wg.hashCode(),wg);
        }
        hm = temp;
        dict = ident;
    }
    
    public void printHashMapInfo(){
        int max = 0;
        int pos = 0;
        System.out.println("the number of keys: " + hm.size() + " " + dict.size());
        for(int i : hm.keySet()){
            //System.out.println(dict.get(i));
            //System.out.println(hm.get(i));
            if(hm.get(i).size()>max){
                max = hm.get(i).size();
                pos = i;
            }
        }
        for(int i : hm.keySet()){
            if(hm.get(i).size()==max){
                System.out.println("KEY IS: " + dict.get(i));
            }
        }
        System.out.println("size of the largest value : " + max);
        
        
    }
    // public void buildMap(){
        // HashMap<String,ArrayList<String>> temp = new HashMap<String,ArrayList<String>> ();
        // for(int k=0; k < myText.length - 1; k++){
            // String key = myText[k];
            // if(!temp.containsKey(key)){
                // if(k + 1 < myText.length){
                    // ArrayList<String> al = new ArrayList<String>(); 
                    // al.add(myText[k+1]);
                    // temp.put(key,al);
                // }
                // // else{
                    // // ArrayList<String> al = new ArrayList<String>(); 
                    // // temp.put(key,al);
                // // }
            // }
            // // if(temp == null){
                // // ArrayList<String> al = new ArrayList<String>();
                // // al.add(myText.substring(k + key.length(),k+key.length()+1));
                // // temp.put(key,al);
            // // }
            // else{
                // //if(k + key.length() < myText.length()){
                    // ArrayList<String> al = temp.get(key);
                    // al.add(myText[k+1]);
                    // temp.put(key,al);
                // //}
            // }
        // }
        // hm = temp;
    // }
    // private ArrayList<String> getFollows(String key) {
        // return hm.get(key);
    // }
    

}
