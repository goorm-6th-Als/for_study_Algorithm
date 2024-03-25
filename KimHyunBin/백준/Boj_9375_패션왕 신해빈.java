import java.io.*;
import java.util.*;

public class Main { // Boj_9375_패션왕 신해빈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Tc = Integer.parseInt(br.readLine());
        for(int T = 0; T < Tc; T++){
            int answer = 1 ;
            Map<String, Integer> item = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i<n; i++){ // 옷 인풋
                st = new StringTokenizer(br.readLine());
                String code = st.nextToken();
                String type = st.nextToken();

                if(!set.contains(code)){
                    set.add(code);
                    item.put(type, item.getOrDefault(type, 0) +1);
                }
            }

            for(int tmp : item.values()){
                answer *= tmp + 1;
            }

            System.out.println(answer - 1); // 다 벗는 경우 제외

        }

    }
}