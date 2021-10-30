package com.cg.main;

public class Anagrams {

	
	static boolean isAnagram(String a, String b) {
		a= a.toLowerCase();
		b=b.toLowerCase();
		boolean res = true;
		if(a.length()!=b.length()) {
			res = false;
		}else {
			int n=0;
			while(n<a.length()) {
				char temp = a.charAt(n);
				int aCount = 0;
				int bCount = 0;
				for(int i=0;i<a.length();i++) {
					if(temp == a.charAt(i))
						aCount++;
					if(temp == b.charAt(i))
						bCount++;
				}
				if(aCount != bCount) {
					return false;
				}
				n++;
			}
		}
		return res;
    }
	
	
	public static void main(String[] args) {
		System.out.println(isAnagram("Hello", "hello"));

	}

}
