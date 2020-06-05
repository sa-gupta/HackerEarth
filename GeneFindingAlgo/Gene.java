/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gene;

/**
 *
 * @author Sachin
 */
public class Gene {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String gene = findGene("ATGTGACCTGATTAATAG");
        System.out.print(gene);
    }


    public static int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex;
        currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1){
            if((currIndex - startIndex) % 3 == 0){
                return currIndex;
            }else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dnaStr.length();
    }

    public static String findGene(String dna){
        int startIndex, stopIndex, taaIndex, tagIndex, tgaIndex;
        startIndex = dna.indexOf("ATG");	/* ATG is the starting codon which marks the starting of gene in dna strand. */
        if(startIndex == -1){
            return "";
        }
     
        taaIndex = findStopCodon(dna, startIndex, "TAA");	/* TAA , TAG , TGA is the stop codon we are looking for in DNA strand
        tagIndex = findStopCodon(dna, startIndex, "TAG");	 * Codon is the collection of three nucleoid
        tgaIndex = findStopCodon(dna, startIndex, "TGA");	 */ 
        int temp = Math.min(taaIndex, tagIndex);
        stopIndex = Math.min(temp, tgaIndex);
        
        if(stopIndex == dna.length()){
            return "";
        }
        
        return dna.substring(startIndex, stopIndex+3);
    }

}
