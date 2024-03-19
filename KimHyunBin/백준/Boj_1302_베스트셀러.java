import java.io.*;
import java.util.*;

public class Main { //Boj_1302_베스트셀러
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> best_Seller = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book_Name = br.readLine();
            if (!best_Seller.containsKey(book_Name)) {
                best_Seller.put(book_Name, 1);
            } else {
                int cnt = best_Seller.get(book_Name);
                best_Seller.put(book_Name, cnt + 1);
            }
        }

        int answer = 0;
        for (String s : best_Seller.keySet()) {
            answer = Math.max(answer, best_Seller.get(s));
        }

        List<String> key_List = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : best_Seller.entrySet()) {
            if (entry.getValue() == answer) {
                key_List.add(entry.getKey());
            }
        }

        Collections.sort(key_List);
        System.out.println(key_List.get(0));

    }
}