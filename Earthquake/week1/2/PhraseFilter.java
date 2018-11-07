
/**
 * 在这里给出对类 PhraseFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class PhraseFilter implements Filter{
    private String type;
    private String title;
    private String name;
    public String getName(){
        return name;
    };
    public PhraseFilter(String where, String info,String n){
        type = where;
        title = info;
        name = n;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(type.equals("start")){
            return title.equals(qe.getInfo().substring(0,title.length()));
        }       
        if(type.equals("end")){
            return title.equals(qe.getInfo().substring(qe.getInfo().length() - title.length(),qe.getInfo().length()));
        }
        if(type.equals("any")){
            for(int i = 0; i < qe.getInfo().length()-title.length(); i++){
                System.out.println(qe.getInfo().substring(i, i + title.length()));
                if(qe.getInfo().substring(i, i + title.length()).equals(title)){
                    System.out.println("true");
                    return true;
                }
            }
        }
        return false;
    }
}
