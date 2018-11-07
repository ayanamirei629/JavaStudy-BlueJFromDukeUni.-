import java.util.*;/**
 * 在这里给出对类 LargestQuakes 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        //int answer = indexOfLargest(list);
        //System.out.println(answer);
        ArrayList<QuakeEntry> answer = getLargest(list,20);
        for(QuakeEntry q: answer){
        System.out.println(q);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int maxIndex = 0;
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getMagnitude() > data.get(maxIndex).getMagnitude()){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        if(quakeData.size() < howMany){
            howMany = quakeData.size();
        }
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry> (quakeData);
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(int i = 0; i < howMany; i++){
            int tempLargest = indexOfLargest(copy);
            answer.add(copy.get(tempLargest));
            copy.remove(tempLargest);
        }
        return answer;
    }
}
