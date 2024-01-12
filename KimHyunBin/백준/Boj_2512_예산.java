import java.util.*;
import java.io.*;

public class Main {// Boj_2512_예산
    static int N, limit;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        budgets = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxBudget = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }

        limit = Integer.parseInt(br.readLine());

        int answer = bs(maxBudget);
        System.out.println(answer);
    }

    private static int bs(int maxBudget) {
        int low = 0;
        int high = maxBudget;
        int result = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (chk_limit(mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static boolean chk_limit(int cap) {
        int total = 0;
        for (int budget : budgets) {
            total += Math.min(budget, cap);
        }
        return total <= limit;
    }
}