
/**
 * 在这里给出对类 wordCount 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;
import java.io.File;
public class wordCount {
    private HashMap <String, ArrayList<String>> wordCount;
    
    public wordCount(){
        wordCount = new HashMap <String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String s: fr.words()){
            if(wordCount.containsKey(s)){
                ArrayList<String> al = wordCount.get(s);
                if(!al.contains(f.getName())){
                    al.add(f.getName());
                    wordCount.put(s,al);
                }
            }
            else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(f.getName());
                wordCount.put(s,al);
            }
        }
        
    }
    
    public void buildWordFileMap(){
        wordCount.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){
        int max = 0;
        int count = 0;
        for(String s : wordCount.keySet()){
            ArrayList<String> al = wordCount.get(s);
            if(al.size() > max){
                max = al.size();
            }
        }
        System.out.println("The greatest number of files a word appears in is : "+ max +" ,and the words: ");
        for(String s : wordCount.keySet()){
            ArrayList<String> al = wordCount.get(s);
            if(al.size() == max){
                count +=1;
                System.out.print(s + " appears in the files: ");
                for (int i = 0; i<al.size();i++){
                    System.out.println(al.get(i)+" ,");
                }
            }
        }
        System.out.println("-----------------" + count);
        return max;
    }
    public void printE(int number){
        int count = 0;
        for(String s : wordCount.keySet()){
            ArrayList<String> al = wordCount.get(s);
            if(al.size() == number){
                count +=1;
                System.out.print(s + " appears in the files: ");
                for (int i = 0; i<al.size();i++){
                    System.out.println(al.get(i)+" ,");
                }
            }
        }
        System.out.println("-----------------" + count);
    }
    public void printFilesIn(String word){
        ArrayList<String> al = wordCount.get(word);
        System.out.print(word + " appears in the files: ");
        for (int i = 0; i<al.size();i++){
            System.out.println(al.get(i)+" ,");
        }
    }
    
    public void tester(){
        buildWordFileMap();
        //System.out.println(wordCount.size());
        //maxNumber();
        printFilesIn("tree");
        //printE(4);
    }
}

