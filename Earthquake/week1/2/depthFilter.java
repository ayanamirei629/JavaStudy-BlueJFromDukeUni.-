
/**
 * 在这里给出对类 depthFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class depthFilter implements Filter{
    private double minDep;
    private double maxDep;
    private String name;
    public String getName(){
        return name;
    };
    public depthFilter(double min, double max,String n){
        minDep = min;
        maxDep = max;
        name = n;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getDepth() >= minDep & qe.getDepth() <= maxDep;
    }
}


