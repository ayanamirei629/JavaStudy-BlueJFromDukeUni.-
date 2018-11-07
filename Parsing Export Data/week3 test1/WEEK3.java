
/**
 * 在这里给出对类 WEEK3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;


public class WEEK3 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //String test = countryInfo(parser, "Nauru");
        //System.out.println(test);
        //listExporterTwoProducts(parser, "cotton","flowers");
        //System.out.println(numberOfExporters(parser, "cocoa"));
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country){
        String info = "";
        String getCountry = "";
        for (CSVRecord record: parser){
            getCountry = record.get("Country");
            if (getCountry.contains(country)){
                info = country + ": ";
                info += record.get("Exports") + ": ";
                info += record.get("Value (dollars)");
            }
        }
        return info;
    }
    
    public void listExporterTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        String export = "";
        for(CSVRecord record : parser){
            export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser,String exportItem){
        int count = 0;
        String export = "";
        for (CSVRecord record: parser){
            export = record.get("Exports");
            if(export.contains(exportItem)){
                count += 1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        String value = "";
        for (CSVRecord record: parser){
            value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                String info = "";
                info += record.get("Country") + " ";
                info += value;
                System.out.println(info);
            }
        }
        
    }
}
