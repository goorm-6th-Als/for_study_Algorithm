import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
        Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        
        int result;
        
        if (a == b && b == c) {
            result = 10000 + a * 1000;
        } else if (a == b && a != c || a == c && a != b) {
            result = 1000 + a * 100;
        } else if (b == c && b != a) {
            result = 1000 + b * 100;
        } else {
            int max = a;
                if (max < b)
                    max = b;
                if (max < c)
                    max = c;
            result = max * 100;
        }
       System.out.println(result);
    }
}
      