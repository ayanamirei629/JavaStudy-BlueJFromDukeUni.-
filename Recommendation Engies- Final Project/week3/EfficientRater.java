
/**
 * 在这里给出对类 EfficientRater 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class EfficientRater {
    private String myID;
    private HashMap<String,Rating> myRatings;

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String,Rating>();
    }
    

    public void addRating(String item, double rating) {
        myRatings.put(item,new Rating(item,rating));
    }

    
    public boolean hasRating(String item){
        // for(String s: myRatings.keySet()){
            // System.out.println(s + " " + myRatings.get(s));
        // }
        return myRatings.containsKey(item);
    }

    public String getID() {
        return myID;
    }

    public double getRating(String item) {

        for(String s: myRatings.keySet()){
            if (myRatings.get(s).getItem().equals(item)){
                return myRatings.get(s).getValue();
            }
        }
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(String s: myRatings.keySet()){
            list.add(myRatings.get(s).getItem());
        }
        return list;
    }
}
