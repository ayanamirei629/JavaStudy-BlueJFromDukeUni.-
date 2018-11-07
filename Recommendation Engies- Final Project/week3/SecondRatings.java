
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<EfficientRater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingsfile){
        FirstRatings fRate = new FirstRatings();
        myMovies = fRate.loadMovies(moviefile);
        myRaters = fRate.loadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    private double getAverageByID(String id, int minimalRaters){
        int count = 0;
        double sum = 0;
        for(EfficientRater r : myRaters){
            //System.out.println("in second loop");
            if(r.hasRating(id)){
                sum += r.getRating(id);
                count += 1;
            }
        }
        if(count < minimalRaters){
            return 0.0;
        }
        return sum/count;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> result = new ArrayList<Rating>();
        for(Movie m : myMovies){
            //System.out.println("in the loop");//check myMovie
            if(getAverageByID(m.getID(),minimalRaters)!=0.0){
                
                Rating r = new Rating(m.getTitle(),getAverageByID(m.getID(),minimalRaters));
                result.add(r);
            }
        }
        return result;
    }
    
    public String getID(String title){
        for(Movie m : myMovies){
            if(m.getTitle() == title){
                return m.getID();
            }
        }
        return "NO SUCH TITLE";
    }
}