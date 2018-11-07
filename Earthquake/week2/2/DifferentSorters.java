
/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample1.atom";
        int count = 0;
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            
            if(count == 600){
                System.out.println(qe);
            }
            count += 1;
        }

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
    
    public void sortByLastWordInTitleThenByMagnitude (){
        EarthQuakeParser parser = new EarthQuakeParser ();
        String source = "earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list,new TitleLastAndMagnitudeComparator());
        int count = 0;
        for(QuakeEntry qe: list) {
            
            if(count == 500){
                System.out.println(qe);
            }
            count += 1;
        
        }
    }
    
    public void sortByTitleAndDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list,new TitleAndDepthComparator());
        int count = 0;
        for(QuakeEntry qe: list) {
            
            if(count == 500){
                System.out.println(qe);
            }
            count += 1;
        
        }
    }
    
    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
}
