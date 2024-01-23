import java.io.*;
import java.util.*;

public class BOJ_2309_일곱_난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int f1 = 0, f2 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    f1 = i;
                    f2 = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != f1 && i != f2) {
                System.out.println(arr[i]);
            }
        }
    }
}
