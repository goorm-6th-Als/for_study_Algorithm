import java.util.*;

public class BOJ_1789_수들의_합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long num = 0;
        int count = 0;

        for (int i = 1;; i++) {
            if (num > S) {
                break;
            }
            num += i;
            count++;
        }
        System.out.println(count - 1);
    }
}