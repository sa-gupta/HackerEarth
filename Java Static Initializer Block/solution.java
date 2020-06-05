import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

static boolean flag ;
static int B;
static int H;
static int area = 0;
static Scanner scan = new Scanner(System.in);

static{
    B = scan.nextInt();
    H = scan.nextInt();
    try{
        if(B < 0 || H<0){
            flag = false;
            throw new Exception();
            
        }else{
            flag = true;
        }
    
    }catch(Exception e){
        System.out.print(e + ": Breadth and height must be positive");
        }

}


//Write your code here

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

