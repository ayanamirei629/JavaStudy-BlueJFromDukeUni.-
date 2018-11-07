
/**
 * 在这里给出对类 Tester 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.Random;
import edu.duke.*;
import java.util.*;
public class Tester {
    public void testGetFollows(){
        MarkovOne mark1 = new MarkovOne();
        mark1.setTraining("this is a test yes this is a test.");
        ArrayList<String> al = mark1.getFollows(".");
        for(String s : al){
            System.out.println(s);
        }
    }
    
    public void testGetFollowsWithFile(){
        MarkovOne mark1 = new MarkovOne();
        FileResource fr = new FileResource();
    	String st = fr.asString();
    	st = st.replace('\n', ' ');
    	mark1.setTraining(st);
    	ArrayList<String> al = mark1.getFollows("o");
    	System.out.println(al.size());
    }
}
