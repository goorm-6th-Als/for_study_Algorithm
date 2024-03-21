package baekjoon;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Boj_1302_베스트_셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String,Integer> books= new HashMap<>();
        int n = parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder book = new StringBuilder();
        for (int i = 0; i < n; i++) {
            book.delete(0, book.length());
            book.append(br.readLine());
            books.put(book.toString(), books.getOrDefault(book.toString(),0)+1);


        }
        int max =0;
        StringBuilder answer = new StringBuilder();;
        for(Map.Entry<String,Integer> tmp : books.entrySet()){
            if(tmp.getValue() > max){max = tmp.getValue();}
        }

        List<String> arr = new ArrayList<>(books.keySet());
        Collections.sort(arr);
        for(String key : arr){
            if(books.get(key) == max) {
                bw.append(key);
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();


    }


}
