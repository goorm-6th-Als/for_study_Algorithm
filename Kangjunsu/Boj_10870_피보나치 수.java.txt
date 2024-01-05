import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int [] b = {0,1};

        if(a==0){
            System.out.println(0);
        }else{
            for(int i =1; i<a; i++){
                int sum = b[0]+b[1];
                b[0]=b[1];
                b[1]=sum;
            }
            System.out.println(b[1]);
        }
    }
}