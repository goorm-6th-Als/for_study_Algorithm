package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int maxSize = 1;

        Map<String,Integer> books = new HashMap<>();

        for(int i = 0; i<size; i++) {
            String key = br.readLine();
            if (books.containsKey(key)) {
                Integer value = books.get(key) +1;
                books.put(key, value);
                if(value > maxSize){
                    maxSize++;
                }
            }else{
                books.put(key, 1);
            }
        }

        int finalMaxSize = maxSize;
        Map.Entry<String, Integer> stringIntegerEntry = books.entrySet().stream()
                .filter(entry -> entry.getValue() == finalMaxSize)
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .findFirst().get();

        System.out.println(stringIntegerEntry.getKey());
    }
}
