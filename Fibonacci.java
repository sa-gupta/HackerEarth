public class Fibonacci
{
	public static void main(String[] args) {

        int n,i, t1 = 0, t2 = 1, sum = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        n = scan.nextInt();
        System.out.print("First " + n + " terms: ");

        for (i = 0; i < n; i++)
        {
            
            System.out.print(t1 + "  ");
            sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}
