
/**
 * 在这里给出对类 MovieRunnerWithFilters 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatings(35);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // System.out.println(r.getItem() + "  " + r.getValue());
        // }
        double min = 10.0;
        for(Rating r : result){
            if(min > r.getValue()){
                min = r.getValue();
            }
        }
        for(Rating r : result){
            if(r.getValue() == min){
                System.out.println("THE MOVIE WITH MINIMUM AVERAGE SCORE IS : " + r.getItem() + "  " + r.getValue());
            }
        }
    }
    
    public void printAverageRatingsByYear(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(20);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // //System.out.println(MovieDatabase.getID(r.getItem()));
            // int year = MovieDatabase.getYear(MovieDatabase.getID(r.getItem()));
            // System.out.println(r.getItem() + "  " + r.getValue() + "  " + "in the year: " + year);
        // }
    }
    
    public void printAverageRatingsByGenre(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(20);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // //System.out.println(MovieDatabase.getID(r.getItem()));
            // String GenreOut = MovieDatabase.getGenres(MovieDatabase.getID(r.getItem()));
            // System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Genres: " + GenreOut);
        // }
    }
    
    public void printAverageRatingsByMinutes(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(5);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // //System.out.println(MovieDatabase.getID(r.getItem()));
            // int time = MovieDatabase.getMinutes(MovieDatabase.getID(r.getItem()));
            // System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Time: " + time);
        // }
    }
    
    public void  printAverageRatingsByDirectors(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(4);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        for(Rating r : result){
            //System.out.println(MovieDatabase.getID(r.getItem()));
            String director = MovieDatabase.getDirector(MovieDatabase.getID(r.getItem()));
            System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Directors: " + director);
        }
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(8);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // //System.out.println(MovieDatabase.getID(r.getItem()));
            // int year = MovieDatabase.getYear(MovieDatabase.getID(r.getItem()));
            // String GenreOut = MovieDatabase.getGenres(MovieDatabase.getID(r.getItem()));
            // System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Year: " + year + "  Genres: " + GenreOut);
        // }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings thirdRate = new ThirdRatings("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +thirdRate.getRaterSize());
        ArrayList<Rating> result = thirdRate.getAverageRatingsByFilter(3);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        // for(Rating r : result){
            // //System.out.println(MovieDatabase.getID(r.getItem()));
            // int time = MovieDatabase.getMinutes(MovieDatabase.getID(r.getItem()));
            // String director = MovieDatabase.getDirector(MovieDatabase.getID(r.getItem()));
            // System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Time: " + time + "  Directors: " + director);
        // }
    }
}
