
/**
 * 在这里给出对类 DirectorsFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class DirectorsFilter implements Filter{
    private String directorsIn;
    private ArrayList<String> directorSet;
    public DirectorsFilter(String directors){
        directorsIn = directors;
        directorSet = getList(directorsIn);
    }
    
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
    
    @Override
    public boolean satisfies(String id) {
        String movieDirector = MovieDatabase.getDirector(id);
        ArrayList<String> movieDirectorSet = getList(movieDirector);
        for(String s : movieDirectorSet){
            if(directorSet.contains(s)){
                return true;
            }
        }
        return false;
    }
    
    
}
