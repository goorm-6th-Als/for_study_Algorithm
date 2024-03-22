import java.io.*;
import java.util.*;

public class Main { // goorm_1회차 최고의 메뉴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int best = -1;

        Map<Integer, Integer> menu = new HashMap<>();
        for(int i = 0; i<M; i++){ // a번
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            menu.put(num, menu.getOrDefault(num,
                    0)+ cnt);
            best = Math.max(best,menu.get(num));
        }

        List<Integer> key_List = new ArrayList<>(); // 최대값 넣어서 가장 앞 번호 출력
        for (Map.Entry<Integer, Integer> entry : menu.entrySet()) {
            if (entry.getValue() == best) {
//                System.out.println("entry = " + entry);
//                System.out.println("entry.getValue() = " + entry.getValue());
                key_List.add(entry.getKey());
            }
        }
        Collections.sort(key_List);
        System.out.println(key_List.get(key_List.size()-1));

    }
}