
/**
 * 在这里给出对类 MarkovZero 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.Random;
import edu.duke.*;

public class MarkovZero extends AbstractMarkovModel{
    // private String myText;
    // private Random myRandom;
    
    public MarkovZero() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0; k < numChars; k++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        
        return sb.toString();
    }
    
    public String toString(){
        return "MarkovModel of order 0";
    }
}
