
/**
 * 在这里给出对类 TitleLastAndMagnitudeComparator 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        String s1 = q1.getInfo();
        String s2 = q2.getInfo();
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");
        s1 = a1[a1.length -1];
        s2 = a2[a2.length -1];
        if(s1.compareTo(s2) != 0){
            return s1.compareTo(s2);
        }
        else{
            if(Double.compare(q1.getMagnitude(), q2.getMagnitude()) != 0){
                return Double.compare(q1.getMagnitude(),q2.getMagnitude());
            }
            else{
                return 0;
            }
        }
    }
}
