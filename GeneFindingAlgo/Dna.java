import edu.duke.*;

public class Dna {

    public static void main(String[] args) {

        testgetAllGenes();


    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon){

        int currIndex = dna.indexOf(stopCodon, startIndex+1);
        while(currIndex != -1 ){
            if((currIndex - startIndex) % 3 == 0){ return currIndex; }
            currIndex = dna.indexOf(stopCodon, currIndex+stopCodon.length());
        }

        return dna.length();
    }


    public static String findGene(String dna, int where) {

        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) { return ""; }

        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");

        int minIndex = 0;

        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else { minIndex = taaIndex; }

        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }

        if (minIndex == -1 ){ return ""; }

        return dna.substring(startIndex, minIndex+3);
    }

    public static StorageResource getAllGenes(String dna){

        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        dna = dna.toUpperCase();        //converts to uppercase in case of lowercase

        while ( true ) {
            String gene = findGene(dna, startIndex);
            if (gene.isEmpty()) { break; }
            geneList.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneList;
    }

    public static void testgetAllGenes(){
        String dna = "/*  Insert Your DNA here  */";
        StorageResource genes = getAllGenes(dna);
        System.out.println(countCTG(dna));
        
        for(String s: genes.data()){
         
            System.out.println(s);
            System.out.println(s.length());
            
        }
    }

    public static float cgRatio(String dna){

        int CGcounter = 0;
        String CG = "CG";

        for(int i=0; i<dna.length(); i++){
            if(dna.charAt(i) == CG.charAt(0) || dna.charAt(i) == CG.charAt(1)){
                CGcounter++;
            }
        }
        return (float)CGcounter/dna.length();
    }

    public static int countCTG(String dna){

        int counter = 0, start = 0;

        while(true){
            int startIndex = dna.indexOf("CTG", start);
            if(startIndex == -1){ break; }
            counter++;
            start = startIndex + 2;
        }
        return counter;
    }

   

   

   


   



}
