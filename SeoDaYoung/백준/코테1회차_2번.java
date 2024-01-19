import java.util.*;

public class 코테1회차_2번 { // BOJ_1789_수들의_합
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        long num = 0;
        int count = 0;

        for (int i=1;; i++) {
            num+=i;
            count++;
            if (num>S) {
            break;
            }
        }

        System.out.println(count-1);

    }
}
