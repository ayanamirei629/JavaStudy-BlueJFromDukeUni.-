
/**
 * 在这里给出对类 MovieRunnerAverage 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import java.util.*;
public class MovieRunnerAverage {
    public void printAverageRatings(){
        SecondRatings secRate = new SecondRatings("data/ratedmoviesfull.csv","ratings.csv");
        System.out.println("MOVIE AND RATER SIZE: " + secRate.getMovieSize() +" " +secRate.getRaterSize());
        ArrayList<Rating> result = secRate.getAverageRatings(12);
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
    public void testOnly(){
        SecondRatings secRate = new SecondRatings("ratedmovies_short.csv","ratings_short.csv");
        System.out.println("MOVIE AND RATER SIZE: " + secRate.getMovieSize() +" " +secRate.getRaterSize());
        ArrayList<Rating> result = secRate.getAverageRatings(1);
        System.out.println("TEST FOR AVERAGE RATINGS IN " + result.size() + " FILE: ");
    }
    public void getAverageRatingOneMovie(){
        SecondRatings secRate = new SecondRatings("ratedmoviesfull.csv","ratings.csv");
        String ID = secRate.getID("Vacation");
        ArrayList<Rating> rat = new ArrayList<Rating>();
        rat = secRate.getAverageRatings(3);
        for(Rating r: rat){
            if(r.getItem().equals("Moneyball")){
                System.out.println("THE AVERAGE RATING OF THE MOVIE IS : " + r.getValue());
            }
        }
        
    }
}    
