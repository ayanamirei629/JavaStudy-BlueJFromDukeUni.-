
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        // sortByMagnitude(list);
        //sortByLargestDepth(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        // for (QuakeEntry qe: list) { 
            // System.out.println(qe);
        // } 
        //System.out.println(list.get(list.size() - 1));
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quake){
        for(int i=0; i<quake.size()-1;i++){
            if(quake.get(i).getMagnitude()>quake.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry>  in){
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if(checkInSortedOrder(in)){
                System.out.println("Finished! Times : " + (i+1));
                return ;
            }
        }
    }
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> quake){
        for(int i=0; i < quake.size() - 1;i++){
            onePassBubbleSort(quake,i);
            if(checkInSortedOrder(quake)){
                System.out.println("Finished! Times : " + (i+1));
                return ;
            }
        }
    }
    public void onePassBubbleSort(ArrayList<QuakeEntry> quake,int numSorted){
        for(int i = 0; i < quake.size() - 1; i++){
            if(quake.get(i).getMagnitude() > quake.get(i+1).getMagnitude()){
                QuakeEntry temp = quake.get(i);
                quake.set(i,quake.get(i+1));
                quake.set(i+1,temp);
            }
        }
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i=0; i < in.size() - 1;i++){
            onePassBubbleSort(in,i);
        }
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        int maxIdx = from;
        for(int i = from + 1; i < quakeData.size(); i++){
            if(quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()){
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        int maxIdx = 0;
        for(int i = 0; i < in.size(); i++){
            maxIdx = getLargestDepth(in,i);
            QuakeEntry temp = in.get(i);
            in.set(i,in.get(maxIdx));
            in.set(maxIdx, temp);
            if(i == 49){
                return;
            }
        }
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
