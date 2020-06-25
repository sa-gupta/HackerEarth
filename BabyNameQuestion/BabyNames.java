
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {

    public void printNames () {
        FileResource fr  = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100) {
                System.out.println("Name: " + rec.get(0) + " Gender: "+rec.get(1)+" Num Born: "+rec.get(2));
            }
        }
    }
    
    public void totalBirths (FileResource fr) {
        int girlCounter = 0;
        int boyCounter = 0;
        int totalBoyBirths = 0;
        int totalGirlBirths = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String gender = rec.get(1);
            int births = Integer.parseInt(rec.get(2));
            if(gender.equals("F")){
                girlCounter++;
                totalGirlBirths += births;
            }else{
                if(gender.equals("M")){
                    boyCounter++;
                    totalBoyBirths += births;
                }
            }
        }
        
        System.out.println("Total Boys: "+totalBoyBirths+" Total Girls: "+totalGirlBirths);
        System.out.println("Total Girl Names: "+girlCounter+" Total Boy Names: "+boyCounter);
        System.out.println("--------------------------------------------------------------------------");
    }
    
    public int getRank (int year, String name, String gender) {
        FileResource fr  = new FileResource();
        int rank = -1;
        int girlCounter = 0;
        int boyCounter = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            
            
            if(rec.get(1).equals(gender)){
                girlCounter++;
                if(rec.get(0).equals(name)){
                        rank = girlCounter;
                    }
                
            }else{
                if(rec.get(1).equals(gender)){
                    boyCounter++;
                    if(rec.get(0).equals(name)){
                        rank = boyCounter;
                    }
                    
                    
                }
            }
        }
        
        return rank;
    }
    
    public String getName (int year, int rank, String gender) {
        String name = null;
        FileResource fr  = new FileResource();
        int girlCounter = 0;
        int boyCounter = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            
            
            if(rec.get(1).equals(gender)){
                girlCounter++;
                if(girlCounter == rank){
                        name = rec.get(0);
                    }
                
            }else{
                if(rec.get(1).equals(gender)){
                    boyCounter++;
                    if(boyCounter == rank){
                        name  = rec.get(0);
                    }
                    
                    
                }
            }
        }
        
        return name;
    }
    
    public String whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
        int oldRank = getRank(year, name, gender);
        String newName = getName(newYear, oldRank, gender);

        System.out.println(name + "born in " + year + " would be " + newName + " if he/she was born in " + newYear);
        System.out.println("--------------------------------------------------------------------------");
        return newName;
    }

    //TEST method for whatIsNameInYear
    public  void testWhatIsNameInYear(){
        whatIsNameInYear("Isabella", 2012, 2014, "F");      //Sophia
        whatIsNameInYear("Noah", 2013, 2012, "M");          //Jacob
    }
    
    public void testGetName () {
        String gender = "M";
        int rank = 1;
        System.out.println("Male with Rank: "+rank+" Born in 2014"+" has Name: "+getName(2014,rank,gender));
        System.out.println("--------------------------------------------------------------------------");
    }
    
    public void testGetRank() {
        String name = "Sophizsd";
        String gender = "F";
        System.out.println(name + " has Rank: " + getRank(2014,name,gender));
        System.out.println("--------------------------------------------------------------------------");
    }
    
    public void testTotalBirths () {
        FileResource fr  = new FileResource();
        totalBirths(fr);
    }
}










