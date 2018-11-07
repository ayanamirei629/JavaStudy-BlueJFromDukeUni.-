
/**
 * 在这里给出对类 TitleAndDepthComparator 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String s1 = q1.getInfo();
        String s2 = q2.getInfo();
        if(s1.compareTo(s2) != 0){
            return s1.compareTo(s2);
        }
        else{
            if(Double.compare(q1.getDepth(),q2.getDepth()) != 0){
                return Double.compare(q1.getDepth(),q2.getDepth());
            }
            else{
                return 0;
            }
        }
    }
}
