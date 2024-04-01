import java.io.*;
import java.util.*;

public class Main { // Boj_2002_추월
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        Map<String, Integer> entering_List = new HashMap<>();
        List<String> outgoing_Order = new ArrayList<>();

        for (int i = 1; i <= N; i++) { // 대근 입구
            String car = br.readLine();
            entering_List.put(car, i);
        }
        for (int i = 1; i <= N; i++) { // 영식 출구
            String car = br.readLine();
            outgoing_Order.add(car);
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (entering_List.get(outgoing_Order.get(i)) > entering_List.get(outgoing_Order.get(j))) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}