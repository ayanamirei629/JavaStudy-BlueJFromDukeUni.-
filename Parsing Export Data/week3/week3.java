
/**
 * 在这里给出对类 week3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class week3 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRow : parser){
            coldestSoFar = getColder(currentRow, coldestSoFar);
        }
        return coldestSoFar;
    }
    
    public CSVRecord getColder(CSVRecord currentRow, CSVRecord coldestSoFar){
        if(coldestSoFar == null){
            coldestSoFar = currentRow;
        }
        else{
            double currentIndex = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestIndex = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (currentIndex < coldestIndex){
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }
    
    public CSVRecord coldestInFile(){
        CSVRecord coldestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            coldestSoFar =getColder(current,coldestSoFar);
        }     
        return coldestSoFar;
    }

    public void testColdestInFile(){
        CSVRecord coldest = coldestInFile();
        System.out.println("coldest: " + coldest.get("TemperatureF") + "DATE" + coldest.get("DateUTC"));
    }
    
    public CSVRecord  lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumid = null;
        for(CSVRecord currentRow : parser){
            lowestHumid = getlower(currentRow, lowestHumid);
        }
        return lowestHumid;
    }
    
    public CSVRecord getlower(CSVRecord currentRow, CSVRecord coldestSoFar){
        if(coldestSoFar == null){
            coldestSoFar = currentRow;
        }
        else{
            double currentIndex = Double.parseDouble(currentRow.get("Humidity"));
            double coldestIndex = Double.parseDouble(coldestSoFar.get("Humidity"));
            if (currentIndex < coldestIndex){
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }
    
    public CSVRecord LowestInFile(){
        CSVRecord lowestHumid = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            lowestHumid = getlower(current, lowestHumid);
        }
        return lowestHumid;        
    }
    
    public void testLowestHumid(){
        CSVRecord lowest = LowestInFile();
        System.out.println("lowest humid: " + lowest.get("Humidity") + "DATE" + lowest.get("DateUTC"));
    }
    
    public void aveTemp(CSVParser parser){
        double aveTemp = 0.0;
        int count = 0;
        for (CSVRecord currentTemp : parser){
            double currentIndex = Double.parseDouble(currentTemp.get("TemperatureF"));
            aveTemp += currentIndex;
            count += 1;        
    }
        aveTemp = aveTemp / count;
        System.out.println("Average Temp is: " + aveTemp);
    }
    
    public void aveTempInFile(CSVParser parser, double value){
        double aveTemp = 0.0;
        int count = 0;
        for (CSVRecord currentTemp : parser){
            double currentIndex = Double.parseDouble(currentTemp.get("TemperatureF"));
            aveTemp += currentIndex;
            count += 1;        
    }
        aveTemp = aveTemp / count;
        if (aveTemp > value){
            System.out.println("Average Temp when high Humidity is: " + aveTemp);
        }
        else{
            System.out.println("No higher situation");
        }
    }
    
    public void testOn(){
        FileResource fr = new FileResource("data/2013/weather-2013-09-02.csv");
        //aveTemp(fr.getCSVParser());
        aveTempInFile(fr.getCSVParser(), 41.0);
    }
}

  
