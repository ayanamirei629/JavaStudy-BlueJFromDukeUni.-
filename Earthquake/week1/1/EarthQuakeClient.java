import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry q : quakeData){
            if (q.getMagnitude() > magMin){
                answer.add(q);
            }
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry q : quakeData){
            if(q.getLocation().distanceTo(from) < distMax * 1000){
                answer.add(q);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry q : quakeData){
            if(where == "end"){
                String test = q.getInfo().substring(q.getInfo().length() - phrase.length(),q.getInfo().length());
                if(q.getInfo().substring(q.getInfo().length() - phrase.length(),q.getInfo().length()).equals(phrase)){
                    answer.add(q);
                }
            }
            if(where == "start"){
                if(q.getInfo().substring(0,phrase.length()).equals(phrase)){
                answer.add(q);
                }
            }
            if(where == "any"){
                for(int i=0; i < q.getInfo().length() - phrase.length(); i ++){
                    if(q.getInfo().substring(i, i + phrase.length()).equals(phrase)){
                        answer.add(q);
                    }
                }
            }
        }
        return answer;
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> answer = filterByPhrase(list, "any", "Can");
        for(QuakeEntry q : answer){
            System.out.println(q);
        }
        System.out.println("found " + answer.size() + " quakes match.");
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> answer = filterByMagnitude(list, 5.0);
        for(QuakeEntry q : answer){
            System.out.println(q);
        }
        System.out.println("found " + answer.size() + " quakes match.");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);
            
        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        ArrayList<QuakeEntry> answer = filterByDistanceFrom(list, 1000, city);
        for(QuakeEntry q : answer){            
            System.out.println(q.getLocation().distanceTo(city)/1000.0 + " " + q.getInfo());
        }
        System.out.println("Found " + answer.size() + " quakes that match ");
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry> ();
        for(QuakeEntry q : quakeData){
            if(q.getDepth() < maxDepth & q.getDepth() > minDepth){
                answer.add(q);
            }
        }
        return answer;
    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        ArrayList<QuakeEntry> answer = filterByDepth(list, -4000, -2000);
        for(QuakeEntry q : answer){
            System.out.println(q);
        }
        System.out.println("found " + answer.size() + " quakes match.");
    }
    
    
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
