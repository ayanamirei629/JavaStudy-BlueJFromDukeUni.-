
/**
 * 在这里给出对类 MovieRunnerSimilarRatings 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class MovieRunnerSimilarRatings {
    public void printAverageRatings(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +RaterDatabase.size());
        ArrayList<Rating> result = fourthRate.getAverageRatings(35);
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
    
    public void printAverageRatingsByYearAfterAndGenre(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        System.out.println("MOVIE AND RATER SIZE: " + MovieDatabase.size() +" " +RaterDatabase.size());
        ArrayList<Rating> result = fourthRate.getAverageRatings(35);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
        for(Rating r : result){
            //System.out.println(MovieDatabase.getID(r.getItem()));
            int year = MovieDatabase.getYear(MovieDatabase.getID(r.getItem()));
            String GenreOut = MovieDatabase.getGenres(MovieDatabase.getID(r.getItem()));
            System.out.println(r.getItem() + "  " + r.getValue() + "  " + "Year: " + year + "  Genres: " + GenreOut);
        }
    }
    
    public void printSimilarRatings(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> result = fourthRate.getSimilarRatings("71",20,5);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
        
    }
    
    public void printSimilarRatingsByGenre(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> result = fourthRate.getSimilarRatingsByFilter("964",20,5);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByDirector(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> result = fourthRate.getSimilarRatingsByFilter("120",10,2);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByGenreAndMinutes(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> result = fourthRate.getSimilarRatingsByFilter("168",10,3);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes(){
        FourthRatings fourthRate = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        ArrayList<Rating> result = fourthRate.getSimilarRatingsByFilter("314",10,5);
        System.out.println(MovieDatabase.getTitle(result.get(0).getItem()));
    }
}
