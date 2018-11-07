
/**
 * 在这里给出对类 mostFrequentWord 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.ArrayList;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer>myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index != -1){
                myFreqs.set(index,myFreqs.get(index)+1);
            }
            else{
                myWords.add(s);
                myFreqs.add(1);
            }
        }
        
    }
    
    public void tester(){
        findUnique();
        System.out.println("Number of unqie words: " + myWords.size());
        for(int i = 0; i < myWords.size(); i++){
            //System.out.println(myFreqs.get(i) + "\t"+ myWords.get(i));
        }
        findIndexOfMax();
    }
    
    public void findIndexOfMax(){
        int max = 0;
        int pos = 0;
        for (int i = 0; i<myWords.size();i++){
            if(max < myFreqs.get(i)){
                max = myFreqs.get(i);
                pos = i;
            }
        }
        System.out.println("max : " + max +"with " + myWords.get(pos));
    }
}
