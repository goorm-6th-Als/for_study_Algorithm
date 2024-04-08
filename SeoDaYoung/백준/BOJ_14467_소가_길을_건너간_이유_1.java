import java.io.*;
import java.util.*;

public class BOJ_14467_소가_길을_건너간_이유_1 {
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[11];

    Arrays.fill(arr, -1);
    int answer = 0;

    while (N-->0) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (arr[a] != -1 && arr[a] != b)
        answer++;
        arr[a] = b;
    }
    System.out.println(answer);
    }
}
