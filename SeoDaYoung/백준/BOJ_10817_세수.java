import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
        
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        in.close();
        
        int s = 0;
        
        if (a>b) {
            if (b>c)
                s = b;
            else if (a>c)
                s = c;
            else
                s = a;
        }
        else {
            if (a>c)
                s = a;
            else if (b>c)
                s = c;
            else 
                s = b;
        }
            System.out.println(s);
    }
}

        