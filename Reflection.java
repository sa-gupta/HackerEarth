package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Reflection {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "cdae";
		System.out.println(isSameReflection(s1, s2));
	}

	static int isSameReflection(String word1, String word2) {
		if (word1.length() != word2.length())
			return -1;
	    Queue<Character> list1 = new LinkedList<>();
		for (int i = 0; i < word1.length(); i++) {
			list1.add(word1.charAt(i));
	    }
		Queue<Character> list2 = new LinkedList<>();
	    for (int i = 0; i < word2.length(); i++) {
	        list2.add(word2.charAt(i));
	    }
	    int k = word2.length();
	    while (k>0) {
	        k--;
	        char ch = list2.peek();
	        list2.remove();
	        list2.add(ch);
	        if (list2.equals(list2))
	            return 1;
	    }
	    return -1;
	}

}
