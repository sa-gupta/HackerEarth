package test;

import java.util.Arrays;
import java.util.Scanner;

public class CountNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		int X[] = new int[N];
		int queries[] = new int[Q];
		
		
		for(int i=0;i<N;i++) {
			int index = scan.nextInt();
			X[index]++;
		}
		
		for(int i=0;i<Q;i++) {
			queries[i] = scan.nextInt();
		}
		long[] list = new long[Q];
		for(int i=0;i<Q;i++) {
			int q = queries[i];
			int max = -1;
			if(X[q] == 0) {
				max = X[q-1];
				if(max < X[q+1]) {
					max = X[q+1];
				}
			}
			else {
				max = X[q];
			}
			list[i] = max;
		}
		System.out.println(Arrays.toString(list)); // return list;
	}

}
