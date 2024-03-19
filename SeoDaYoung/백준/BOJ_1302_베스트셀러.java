import java.io.*;
import java.util.*;

public class BOJ_1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String maxBook = "";
        int max = 0;

        for (int i = 0; i < n; i++) {
            String book = br.readLine();

            if (!map.containsKey(book)) {
                map.put(book, 1);
            } else {
                map.put(book, map.get(book) + 1);
            }
        }

        // key: 책 제목, value: 판매량
        for (String key : map.keySet()) {
            int value = map.get(key);

            if (max == value && maxBook.compareTo(key) > 0) {
                maxBook = key;
                max = value;
            } else if (max < value) {
                maxBook = key;
                max = value;
            }
        }
        System.out.println(maxBook);
    }
}
