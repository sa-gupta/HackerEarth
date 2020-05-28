import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                System.out.printf("%-15s%03d%n", s1, x);
                /*Here, -15 means giving 15 character space to the right of the string including the string.
                  03 means printing 0s on the left of integer if the integer is < 3 digits.
                */
                
            }
            System.out.println("================================");

    }
}
