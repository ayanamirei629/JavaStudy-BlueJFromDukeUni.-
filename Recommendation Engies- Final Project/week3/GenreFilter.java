
/**
 * 在这里给出对类 GenreFilter 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class GenreFilter implements Filter{
    private String genreIn; 
    public GenreFilter(String genre){
        genreIn = genre;
    }
    @Override
    public boolean satisfies(String id) {
        if(MovieDatabase.getGenres(id).indexOf(genreIn)!= -1){
            // System.out.println("whole genres: " + MovieDatabase.getGenres(id));
            // System.out.println("input genres: " + genreIn);
            // System.out.println("in the position: " + MovieDatabase.getGenres(id).indexOf(genreIn));
            return true;
        }
        return false;
    }
}
