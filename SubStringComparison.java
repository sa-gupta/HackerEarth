

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringComparison {

	public static void main(String[] args) {
//		System.out.println(getSmallestAndLargest("welcometojava", 3));
		
		System.out.println(getSmallestAndLargestAnother("welcometojava", 3));
		
		System.out.println("wel".compareTo("ava"));
	}
	private static String getSmallestAndLargestAnother(String s, int k) {
		String smallest = "";
        String largest = "";
        String[] list = new String[(s.length()-k)+1];
        int n = 0;
        while(n!=(s.length()-k)+1) {	
        	list[n] = s.substring(n, n+k);
        	n++;
        }
        
        for (String string : list) {
			System.out.print(string + " ");
		}
        
		return smallest + "\n" + largest;
	}
	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List<String> str = new ArrayList<>();
        int n = 0;
        while(n!=s.length()-(k-1)) {	//n= 0   1   2   3   4   5   6   7   8   9   10  	
        	str.add(s.substring(n, n+k)); //wel elc lco com ome met eto toj oja jav ava 
        	n++;
        }
        Collections.sort(str);
        smallest = str.get(0);
        largest = str.get(str.size()-1);
//        System.out.println(str);
        
        return smallest + "\n" + largest;
    }
}
