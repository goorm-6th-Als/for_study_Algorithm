package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 코테2회차_2번 {
    // 2579 계단 오르기
    static Integer stairs[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        stairs = new Integer[size+1];
        arr = new int[size+1];

        for( int i = 1; i< stairs.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        stairs[0] = arr[0];
        stairs[1] = arr[1];

        if(size >=2){
            stairs[2] = arr[1] + arr[2];
        }

        System.out.println(find(size));

    }

    private static int find(int size) {

        if(stairs[size] == null){
            stairs[size] = Math.max(find(size-2),find(size-3) + arr[size-1]) +arr[size];
        }
        return stairs[size];
    }
}
