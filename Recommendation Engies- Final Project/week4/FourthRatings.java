
/**
 * 在这里给出对类 FourthRatings 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import java.util.*;
public class FourthRatings {
    private int dotProduct(Rater me,Rater r){
        ArrayList<String> list = me.getItemsRated();
        int dotProduct = 0;
        for(String s : list){
            if(r.hasRating(s)){
                dotProduct += (r.getRating(s)-5)*(me.getRating(s)-5);
            }
        }
        return dotProduct;
    }
    
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : RaterDatabase.getRaters()){
            if(!r.getID().equals(me.getID())){
                if(dotProduct(me,r)>= 0){
                    Rating temp = new Rating(r.getID(),dotProduct(me,r));
                    list.add(temp);
                }
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<Rating> result = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        if(numSimilarRaters > list.size()){
            System.out.println("error input");
        }
        int sum = 0;
        int count = 0;
        // for(int i= 0; i<list.size();i++){
            // Rating rat = list.get(i);
            // System.out.println("the rating id is " + rat.getItem() + " with value: " + rat.getValue());
        // }
        for(String movieID : movies){
            for(int i=0; i < numSimilarRaters; i++){
                Rating r = list.get(i);
                Rater rater = RaterDatabase.getRater(r.getItem());
                if(rater.hasRating(movieID)){
                    sum += r.getValue() * rater.getRating(movieID);
                    count += 1;
                }
            }
            // System.out.println(MovieDatabase.getTitle(movieID));
            // System.out.println("THE SUM IS: " + sum + " THE COUNT IS: " + count);
            if(count >= minimalRaters){
                Rating temp = new Rating(movieID,sum/count);
                result.add(temp);
            }
            sum = 0;
            count = 0;
        }
        Collections.sort(result,Collections.reverseOrder());
        return result;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<Rating> result = new ArrayList<Rating>();
        AllFilters f = new AllFilters();
        f.addFilter(new YearAfterFilter(1975));
        //f.addFilter(new GenreFilter("Drama"));
        f.addFilter(new MinutesFilter(70,200));
        //f.addFilter(new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        ArrayList<String> movies = MovieDatabase.filterBy(f);
        //ArrayList<String> movies = MovieDatabase.filterBy(new YearAfterFilter(1980));
        //ArrayList<String> movies = MovieDatabase.filterBy(new GenreFilter("Crime"));
        //ArrayList<String> movies = MovieDatabase.filterBy(new MinutesFilter(110,170));
        ///ArrayList<String> movies = MovieDatabase.filterBy(new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze"));
        if(numSimilarRaters > list.size()){
            System.out.println("error input");
        }
        int sum = 0;
        int count = 0;
        for(String movieID : movies){
            for(int i=0; i < numSimilarRaters; i++){
                Rating r = list.get(i);
                Rater rater = RaterDatabase.getRater(r.getItem());
                if(rater.hasRating(movieID)){
                    sum += r.getValue() * rater.getRating(movieID);
                    count += 1;
                }
            }
            if(count >= minimalRaters){
                Rating temp = new Rating(movieID,sum/count);
                result.add(temp);
            }
            sum = 0;
            count = 0;
        }
        Collections.sort(result,Collections.reverseOrder());
        return result;
    }
    private double getAverageByID(String id, int minimalRaters){
        int count = 0;
        double sum = 0;
        ArrayList<Rater> list = RaterDatabase.getRaters();
        for(Rater r : list){
            if(r.hasRating(id)){
                sum += r.getRating(id);
                count += 1;
            }
        }
        // for(EfficientRater r : ourRaters){
            // //System.out.println("in second loop");
            // if(r.hasRating(id)){
                // sum += r.getRating(id);
                // count += 1;
            // }
        // }
        if(count < minimalRaters){
            return 0.0;
        }
        return sum/count;
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
}
