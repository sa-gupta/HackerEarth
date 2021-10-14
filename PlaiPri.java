package test;

import java.util.Scanner;

public class PlaiPri {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int L = scan.nextInt();
		int R = scan.nextInt();
		
		int count = 0;
		for(int i = L;i<=R;i++) {
			if(isPrime(i) && isPalin(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	static boolean isPrime(int N) {
		if(N == 1) {
			return false;
		}
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(N%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalin(int N) {
		int r,sum=0,temp;    
		temp=N;    
		while(N>0){    
			r=N%10;
			sum=(sum*10)+r;    
		    N=N/10;    
		}    
		if(temp==sum)
			return true;
		else
			return false;
	}
}
