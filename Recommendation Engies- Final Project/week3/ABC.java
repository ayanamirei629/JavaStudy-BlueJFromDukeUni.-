
/**
 * 在这里给出对类 ABC 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class ABC {
    public ArrayList<String> getList(String input){
        ArrayList<String> result = new ArrayList<String>();
        int pos = 0;
        while(input.indexOf(",",pos)!= -1){
            //System.out.println("The index start at pos " + pos + " is: " + input.indexOf(",",pos));
            result.add(input.substring(pos,input.indexOf(",",pos)));
            pos = input.indexOf(",",pos) + 1;
        }
        result.add(input.substring(pos,input.length()));
        return result;
    }
    
    public void test(){
        ArrayList<String> answer = getList("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        for(String s : answer){
            System.out.println(s);
        }
    }
}
