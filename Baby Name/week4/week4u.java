
/**
 * 在这里给出对类 week4u 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class week4u {
    public void totalBirths(){
        FileResource fr = new FileResource();
        int totalBirths = 0;
        int fBirths = 0;
        int mBirths = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            int numBirths = Integer.parseInt(record.get(2));
            totalBirths += numBirths;
            if( record.get(1).equals("F")){
                fBirths += numBirths;
            }
            else{
                mBirths += numBirths;
            }
        }
        System.out.println("num of total: " + totalBirths);
        System.out.println("num of boys: " + mBirths);
        System.out.println("num of girls: " + fBirths);
    }
    
    public int getRank(int year, String name, String gender){
        FileResource fr = new FileResource("data/yob" + year +".csv");
        int rank = 0;
        int tempRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                tempRank += 1;
                if(record.get(0).equals(name)){
                    rank = tempRank;
                }
            }
        }
        if (rank == 0){
            return -1;
        }
        return rank;
    }
    
    public String getName(int year, int rank,String gender){
        FileResource fr = new FileResource("data/yob" + year +".csv");
        int tempRank = 0;
        String name = "";
        for (CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                tempRank += 1;
                if (tempRank == rank){
                    name = record.get(0);
                }
            }
        }
        if (name.length() == 0){
            name = "NO NAME";
        }
        return name;
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        FileResource fr1 = new FileResource("data/yob" + year +".csv");
        FileResource fr2 = new FileResource("data/yob" + newYear +".csv");
        int rank = getRank(year,name,gender);
        String nameNewYear = getName(newYear, rank, gender);
        String testGender = "";
        if (gender == "F"){
            testGender = "She";
        }
        else{
            testGender = "He";
        }
        System.out.println(name + " born in " + year + " would be " + nameNewYear + " if " + testGender + " borns in " + newYear);
    }
    
    public void yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int tempRank = 0;
        int rank = 0;
        int tempH = 0;
        String tempY = "";
        for (File f : dr.selectedFiles()){
            tempRank = 0;
            rank = 0;
            FileResource fr = new FileResource(f);
            for(CSVRecord record : fr.getCSVParser(false)){
                if(record.get(1).equals(gender)){
                tempRank += 1;
                if(record.get(0).equals(name)){
                    rank = tempRank; 
                    }        
                }
            }
        
            if (rank == 0){
                rank = -1;
            }
            if (tempH == 0 && rank != -1){
                tempH = rank;
                tempY = f.getName();
            }
            else{
                if(tempH > rank && rank != -1){
                    tempH = rank;
                    tempY = f.getName();
                }
           
                }
            System.out.println(f.getName() + ": " + rank);
        }
        System.out.println("----------------" + tempY + ": " + tempH);
    } 
    
    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int tempRank = 0;
        int rank = 0;
        double total = 0.0;
        int count = 0;
        for (File f : dr.selectedFiles()){
            tempRank = 0;
            rank = 0;
            FileResource fr = new FileResource(f);
            for(CSVRecord record : fr.getCSVParser(false)){
                if(record.get(1).equals(gender)){
                tempRank += 1;
                if(record.get(0).equals(name)){
                    rank = tempRank;
                    }        
                }
            }
        if (rank == 0){
                return -1;
            }
            count += 1;
            total += rank;
        }
        return total/count;
    }
    
    public int getTotalBirthsRankedHigher(int year,String name, String gender){
        int total = 0;
        int numBirths = 0;
        FileResource fr = new FileResource("data/yob" + year +".csv");
        for(CSVRecord record : fr.getCSVParser(false)){
            if (record.get(0).equals(name) && record.get(1).equals(gender)){
                return total;
            }
            else{
                if(record.get(1).equals(gender)){
                    numBirths = Integer.parseInt(record.get(2));
                    total += numBirths;
                }
            }
        }
        return total;
    }
    
    public void testOn(){
        //int rank = getRank(1971,"Frank","M");
        //System.out.println(rank);
        //String name = getName(1982,450,"M");
        //System.out.println(name);
        //whatIsNameInYear("Owen", 1974, 2014, "M");
        //yearOfHighestRank("Mich", "M");
        //double aveRank = getAverageRank("Robert", "M");
        //System.out.println(aveRank);
        int higherBirths = getTotalBirthsRankedHigher(1990,"Drew", "M");
        System.out.println(higherBirths);
    }
}
