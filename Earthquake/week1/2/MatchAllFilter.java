
/**
 * 在这里给出对类 MatchAllFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
import edu.duke.*;
public class MatchAllFilter implements Filter{
    private ArrayList<Filter> fl; 
    public String getName(){
        String name ="";
        for(Filter f: fl){
        name += f.getName() + " ";
        }
        return name;
    }
    
    public MatchAllFilter (){
    fl = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f){
        fl.add(f);
    }
    
    public boolean satisfies(QuakeEntry qe){
        ArrayList<QuakeEntry> q = new ArrayList<QuakeEntry> ();
        ArrayList<QuakeEntry> temp = new ArrayList<QuakeEntry> ();
        for(Filter fi : fl){
        if (!fi.satisfies(qe)){
            return false;
        }
        }
        return true;
    }
    
    }
        

