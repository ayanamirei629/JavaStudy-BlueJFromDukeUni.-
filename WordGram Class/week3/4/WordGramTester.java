import java.util.*;
import edu.duke.*;
public class WordGramTester {
    public void testWordGram(){
        String source = "this is a test this is a test this is a test of words. wioj: jwe.";
        String[] words = source.split("\\s+");
        for(String word : words){
            System.out.println(word);
        }
        
        int size = 4;
        // for(int index = 0; index <= words.length - size; index += 1) {
            // WordGram wg = new WordGram(words,index,size);
            // System.out.println(index+"\t"+wg.length()+"\t"+wg);
        // }
    }
    
    public void testWordGramEquals(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        ArrayList<WordGram> list = new ArrayList<WordGram>();
        int size = 4;
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words,index,size);
            list.add(wg);
        }
        WordGram first = list.get(0);
        System.out.println("checking "+first);
        for(int k=0; k < list.size(); k++){
            //if (first == list.get(k)) {
              if (first.equals(list.get(k))) {
                  System.out.println("matched at "+k+" "+list.get(k));
            }
        }
    }
    public void testShift(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        WordGram wg = new WordGram(words,1,4);
        WordGram out = wg.shiftAdd("I am the last");
        System.out.println(out);
    
    }
    public void testFollow(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        MarkovWord mw = new MarkovWord(2);
        mw.setTraining(source);
        WordGram wg = new WordGram(words,1,2);
        ArrayList<String> answer= mw.getFollows(wg);
        for(String s:answer){
            System.out.println(s);
        }
    }
    
    public void testMap(){
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        EfficientMarkovWord mw = new EfficientMarkovWord(5);
        mw.setRandom(531);
        mw.setTraining(st);
        mw.buildMap();
        mw.printHashMapInfo();

    }
    
}
