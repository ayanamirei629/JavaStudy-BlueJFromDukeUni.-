
/**
 * 在这里给出对类 MinutesFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class MinutesFilter implements Filter{
    private int minT;
    private int maxT;
    public MinutesFilter(int min, int max){
        minT = min;
        maxT = max;
    }

    @Override
    public boolean satisfies(String id) {
        if(MovieDatabase.getMinutes(id) >= minT && MovieDatabase.getMinutes(id) <= maxT){
            return true;
        }
        return false;
    }
}
