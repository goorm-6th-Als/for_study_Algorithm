package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10810_공넣기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int numberOfBucket = Integer.parseInt(st.nextToken());
        int numberOfInput = Integer.parseInt(st.nextToken());

        int[] Buckets = new int[numberOfBucket+1];

        for(int i = 0; i<numberOfInput; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for(int j = start; j<=end; j++){
                Buckets[j] = value;
            }
        }

        for(int i = 1; i<Buckets.length; i++){
            sb.append(Buckets[i]).append(" ");
        }

        System.out.println(sb);
    }
}
