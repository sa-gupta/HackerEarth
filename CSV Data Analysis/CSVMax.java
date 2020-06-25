
/**
 * Write a description of CSVMax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class CSVMax {
    
    public CSVRecord hottestHourInFile (CSVParser parser) {
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser){
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp < largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        
        return largestSoFar;
    }
    
    public void testHottestInDay () {
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("Coldest Temprature was " + largest.get("TemperatureF"));
    }
    
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if(largestSoFar == null) {
                largestSoFar = currentRow;
            }else {
                if(currentRow.get("Humidity").equals("N/A")){
                    continue;
                }else{
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double largestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
               // if(currentTemp == -9999){
               //     continue;
               // }else{
                    if(currentTemp < largestTemp){
                    largestSoFar = currentRow;
                }
                //}
            }
            }
        }
        
        return largestSoFar;
    }
    
    public void testHottestInManyDays () {
        CSVRecord largest = hottestInManyDays();
        System.out.println("Lowest Humidity was " + largest.get("Humidity") + " Date : " + largest.get("DateUTC") + " Time : " + largest.get("TimeEST"));
    }
    
    public CSVRecord lowestHumid (CSVParser parser) {
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser){
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double largestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
                if(currentTemp < largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        
        return largestSoFar;
    }
    
    public void testLowestHumid () {
         FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("Coldest Temprature was " + largest.get("Humidity") + " Time : " + largest.get("TimeEDT"));
    
    }
}
