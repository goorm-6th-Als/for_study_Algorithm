import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        int answer =0;

        for(int i =0; i<Integer.parseInt(a); i++){
            answer += (b.charAt(i)-'0');
        }

        System.out.println(answer);

    }
}