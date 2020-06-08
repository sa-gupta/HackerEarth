import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Currency {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat forIndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat forUs = NumberFormat.getCurrencyInstance(new Locale("en","US"));
        NumberFormat forChina = NumberFormat.getCurrencyInstance(new Locale("zh","CN"));
        NumberFormat forFrance = NumberFormat.getCurrencyInstance(new Locale("fr","FR"));

        String india = forIndia.format(payment);
        String us = forUs.format(payment);
        String china = forChina.format(payment);
        String france = forFrance.format(payment);

        
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
