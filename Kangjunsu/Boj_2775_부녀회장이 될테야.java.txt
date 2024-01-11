import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t;  i++){
            int k = Integer.parseInt(br.readLine());  //k층
            int n = Integer.parseInt(br.readLine());  //n호
            int [] nHo = IntStream.range(1, n + 1).toArray(); // 0층 n호까지 초기화

            for(int j=0; j<k; j++){ //0층부터 k층까지
                for(int l =1; l<n; l++){ //각 층마다 n호까지
                    nHo[l]=nHo[l-1]+nHo[l];
                }
            }
            System.out.println(nHo[n-1]);
        }

    }
}