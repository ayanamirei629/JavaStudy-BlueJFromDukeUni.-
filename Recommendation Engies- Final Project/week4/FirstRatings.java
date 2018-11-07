
/**
 * 在这里给出对类 FirstRatings 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename){
        //FileResource fr = new FileResource("data/"+filename);
        FileResource fr = new FileResource(filename);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(CSVRecord record : fr.getCSVParser(false)){
            if(!record.get(0).equals("id")){
                Movie temp = new Movie(record.get(0),record.get(1),record.get(2)
                ,record.get(4),record.get(5),record.get(3),record.get(7),Integer.parseInt(record.get(6)));
                movies.add(temp);
            }
        }
        return movies;
    }
    
    public ArrayList<EfficientRater> loadRaters(String filename){
        FileResource fr = new FileResource("data/"+filename);
        ArrayList<EfficientRater> rates = new ArrayList<EfficientRater>();
        ArrayList<String> IDList = new ArrayList<String>();
        for(CSVRecord record : fr.getCSVParser(false)){
            if(!record.get(0).equals("rater_id")){
                if(!IDList.contains(record.get(0))){
                    IDList.add(record.get(0));
                    EfficientRater temp = new EfficientRater(record.get(0));
                    //System.out.println(record.get(1));
                    temp.addRating(record.get(1),Double.parseDouble(record.get(2)));
                    rates.add(temp);
                }
                else{
                    EfficientRater temp = rates.get(rates.size()-1);
                    temp.addRating(record.get(1),Double.parseDouble(record.get(2)));
                    rates.remove(rates.size()-1);
                    rates.add(temp);
                }
            }
        }
        return rates;
    }
    
    public void testLoadRaters(){
        ArrayList<EfficientRater> rates = loadRaters("ratings.csv");
        System.out.println("There are " + rates.size() + " ratings.");
        ArrayList<String> al = new ArrayList<String>();
        String IDrates = "";
        String IDItem = "";
        EfficientRater IDRater = new EfficientRater("2");
        double maxR = 0;
        int count = 0;
        int maxRBR = 0;
        String maxS = "";
        ArrayList<String> totalItem = new ArrayList<String>();
        for(int i=0;i<rates.size();i++){
            if(rates.get(i).getID().equals("193")){
                al = rates.get(i).getItemsRated();
                IDRater = rates.get(i);
            }
        }
        System.out.print("Rating with the ID are " + al.size() + " : ");
        for(String s : al){
            IDItem += s + ", ";
            System.out.print(IDRater.getRating(s) + ", ");
            if(maxR < IDRater.getRating(s)){
                maxR = IDRater.getRating(s);
            }
        }
        IDItem = IDItem.substring(0, IDItem.length()-2);
        System.out.println("With Item " + IDItem);
        
        for(int i=0;i<rates.size();i++){
            if(rates.get(i).hasRating("1798709")){
                count += 1;
            }
        }
        System.out.println("Number of rating on the item: " + count);
        for(int i=0;i<rates.size();i++){
            al = rates.get(i).getItemsRated();
            for(String s : al){
                if(!totalItem.contains(s)){
                    totalItem.add(s);
                }
            }
        }
        System.out.println("Number of Items are rated : " + totalItem.size());
        for(int i=0;i<rates.size();i++){
            al = rates.get(i).getItemsRated();
            if(maxRBR < al.size()){
                maxRBR = al.size();
                maxS = rates.get(i).getID();
            }
        }
        System.out.println("The ID has most number rated movie: " + maxS);
        System.out.println("The max number of ratings: " + maxRBR);
    }
    
    public void testLoadMovies(){
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        System.out.println("There are " + movies.size() + " movies.");
        int genreCount = 0;
        int maxD = 0;
        int timeCount = 0;
        String director ="";
        HashMap<String, Integer> directInfo = new HashMap<String, Integer>();
        for(int i=0;i<movies.size();i++){
            //System.out.println(movies.get(i).getTitle());
            if(movies.get(i).getGenres().indexOf("Comedy")!= -1){
                genreCount += 1;
            }
            
            String[] temp = movies.get(i).getDirector().split(", ");
            for(String s : temp){
                if(!directInfo.containsKey(s)){
                    directInfo.put(s,1);
                }
                else{
                    directInfo.put(s,directInfo.get(s) + 1);
                }
            } 
            
        }
        for(String st: directInfo.keySet()){
            if(directInfo.get(st) > maxD){
                maxD=directInfo.get(st);
            }
        }
        System.out.print("The director participate the most movies is: ");
        for(String k: directInfo.keySet()){
            if(directInfo.get(k) == maxD){
                director += k + ", ";
            }
        }
        for(int i=0;i<movies.size();i++){
            if(movies.get(i).getMinutes() > 150){
                timeCount += 1;
            }
        }
        System.out.println(director);
        System.out.println("With the number of " + maxD);
        System.out.println("There are " + genreCount + " movies include Comedy");
        System.out.println("The number of movies above the criteria: " + timeCount);
    }
}
