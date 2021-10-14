package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindDistance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] inputDist = new int[N];
		for(int i=0;i<N;i++) {
			inputDist[i] = scan.nextInt();
		}
		int start = scan.nextInt();
		int end = scan.nextInt();
		
		System.out.println(Arrays.toString(funcDistance(inputDist, start, end)));
	}
	
	static int[] funcDistance(int[] inputDist, int start, int end) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int dist: inputDist) {
			if(Math.abs(dist)>=start && Math.abs(dist)<=end) {
				list.add(dist);
			}
		}
		int[] answer = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
