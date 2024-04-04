package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2480_주사위세개 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;

        int first = Integer.parseInt(st.nextToken());

        if(first > max){
            max = first;
        }

        int second = Integer.parseInt(st.nextToken());

        if(second > max){
            max = second;
        }

        int three = Integer.parseInt(st.nextToken());

        if(three > max){
            max = three;
        }

        if(first == second && second == three) {
            System.out.println(10000 + (first*1000));
        }else if(first == second || first == three) {
            System.out.println(1000 + (first*100));
        }else if(three == second && second != first) {
            System.out.println(1000 + (second*100));
        }else {
            System.out.println(max*100);
        }
    }
}
