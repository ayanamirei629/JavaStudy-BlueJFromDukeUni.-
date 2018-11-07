
/**
 * 在这里给出对类 CharactersInPlay 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.ArrayList;
public class CharactersInPlay {
    private ArrayList<String> charName;
    private ArrayList<Integer> charFreq;
    public CharactersInPlay(){
        charName = new ArrayList<String>();
        charFreq = new ArrayList<Integer>();
    }
    public void update(String person){
        if(charName == null){
            charName.add(person);
            charFreq.add(1);
        }
        else{
            int index = charName.indexOf(person);
            if(index == -1){
                charName.add(person);
                charFreq.add(1);
            }
            else{
                charFreq.set(index,charFreq.get(index) + 1);
            }
        }
    }
    
    public void findAllCharacters(){
        charName.clear();
        charFreq.clear();
        FileResource fr = new FileResource();
        for(String s : fr.lines()){
            StringBuilder tempS = new StringBuilder(s);
            int pos = tempS.indexOf(".");
            if(pos != -1){
                update(tempS.substring(0,pos));
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        int max = 0;
        int pos = 0;
        System.out.println(charName.size());
        for(int i = 0; i < charName.size(); i++){
            if(max < charFreq.get(i)){
                max = charFreq.get(i);
                pos = i;
            }        
            //System.out.println("character:\t" + charName.get(i) + "\t with Freqs: " + charFreq.get(i));
        }
        charactersWithNumParts(70,150);
        System.out.println("MAIN CHARACTER: \t" + charName.get(pos) + " with number \t" + charFreq.get(pos));
    }
    
    public void charactersWithNumParts(int num1,int num2){
        for(int i =0; i < charName.size(); i++){
            if(charFreq.get(i) >= num1 && charFreq.get(i) <= num2){
                System.out.println("character:\t" + charName.get(i) + "\t with Freqs: " + charFreq.get(i));
            }
        }
    }
}
