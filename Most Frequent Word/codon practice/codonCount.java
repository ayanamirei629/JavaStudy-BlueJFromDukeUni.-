
/**
 * 在这里给出对类 codonCount 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;
public class codonCount {
    private HashMap<String,Integer> codonCount;
    public codonCount(){
        codonCount = new HashMap<String,Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        codonCount = new HashMap<String,Integer>();
        String trueString = dna.substring(start, dna.length());
        for(int i = 0; i + 3< trueString.length() ; i+=3){
            String shortS = trueString.substring(i,i+3);
            if(codonCount.containsKey(shortS)){
                codonCount.put(shortS,codonCount.get(shortS) + 1);
            }
            else{
                codonCount.put(shortS,1);
            }
        }
        System.out.println("Reading frame starting with " + start + " results in " + codonCount.size() + " unique codons");
    }
    
    public String getMostCommonCondon(){
        int max = 0;
        String key = "";
        for(String s : codonCount.keySet()){
            if(codonCount.get(s)> max){
                max = codonCount.get(s);
                key = s;
            }
        }
        return "most common codon is: " + key + "\twith number: " + max;
    }
    
    public void printCodonCounts(int start,int end){
        System.out.println("Counts of codons between 1 and 5 inclusive are:");
        for(String s : codonCount.keySet()){
            if(codonCount.get(s)>= start && codonCount.get(s) <=end){
                System.out.println( s + " " + codonCount.get(s));
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        String test = fr.asString();
        test = test.trim();
        test =test.toUpperCase();
        for(int i = 0; i < 3; i++){
            buildCodonMap(i, test);
            getMostCommonCondon();
            printCodonCounts(1,8);
        }
    }
}
