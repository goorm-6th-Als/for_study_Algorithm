import java.io.*;
import java.util.*;


public class Main { //Boj_22252_정보 상인 호석

    public static class Data {
        PriorityQueue<Integer> pq;
        Data(){
            pq = new PriorityQueue<>(Collections.reverseOrder());
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<String, Data> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            Data data = map.computeIfAbsent(name, k -> new Data());

            if (query == 1) {
                for (int j = 0; j < count; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    data.pq.add(k);
                }
            } else if(query == 2) {
                for (int j = 0; j < count; j++) {
                    if (!data.pq.isEmpty()) {
                        sum += data.pq.poll();
                    }
                }
            }
        }

        System.out.println(sum);
        br.close();
    }
}