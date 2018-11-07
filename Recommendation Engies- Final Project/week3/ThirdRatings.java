
/**
 * 在这里给出对类 ThirdRatings 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    
    public ThirdRatings(String ratingsfile){
        FirstRatings fRate = new FirstRatings();
        myRaters = fRate.loadRaters(ratingsfile);
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
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters){
        AllFilters f = new AllFilters();
        // f.addFilter(new YearAfterFilter(1990));
        // f.addFilter(new GenreFilter("Drama"));
        //f.addFilter(new MinutesFilter(90,180));
        f.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        ArrayList<String> movies = MovieDatabase.filterBy(f);
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(1980));
        //ArrayList<String> movies = MovieDatabase.filterBy(new GenreFilter("Crime"));
        //ArrayList<String> movies = MovieDatabase.filterBy(new MinutesFilter(110,170));
        ///ArrayList<String> movies = MovieDatabase.filterBy(new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze"));
        ArrayList<Rating> result = new ArrayList<Rating>();
        for(String s : movies){
            if(getAverageByID(s,minimalRaters)!=0.0){
                Rating r = new Rating(MovieDatabase.getTitle(s),getAverageByID(s,minimalRaters));
                result.add(r);
            }
        }
        return result;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        // ArrayList<Rating> result = new ArrayList<Rating>();
        // for(Movie m : myMovies){
            // //System.out.println("in the loop");//check myMovie
            // if(getAverageByID(m.getID(),minimalRaters)!=0.0){
                
                // Rating r = new Rating(m.getTitle(),getAverageByID(m.getID(),minimalRaters));
                // result.add(r);
            // }
        // }
        // return result;
        ArrayList<Rating> result = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String s : movies){
            if(getAverageByID(s,minimalRaters)!=0.0){
                Rating r = new Rating(MovieDatabase.getTitle(s),getAverageByID(s,minimalRaters));
                result.add(r);
            }
        }
        return result;
    }
    

}
