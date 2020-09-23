public class NumberPalindrome {

    public static void main(String[] args) {

        int num, reversedInt = 0, remainder, originalInt;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number : ");
        num = scan.nextInt();
        originalInt = num;

        
        while( num != 0 )
        {
            remainder = num % 10;
            reversedInt = reversedInt * 10 + remainder;
            num  /= 10;
        }

       
        if (originalInteger == reversedInteger)
            System.out.println(originalInt + " is a palindrome.");
        else
            System.out.println(originalInt + " is not a palindrome.");
    }
}
