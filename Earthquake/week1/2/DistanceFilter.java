
/**
 * 在这里给出对类 DistanceFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class DistanceFilter implements Filter{
    private Location loc;
    private double dist;
    private String name;
    public String getName(){
        return name;
    };
    DistanceFilter(Location location, double distance,String n){
        loc = location;
        dist = distance;
        name = n;
        }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(loc) < dist;
    }
}
