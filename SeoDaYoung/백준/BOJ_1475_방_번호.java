import java.io.*;
import java.util.*;

public class BOJ_1475_방_번호 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[10];

        for (char c : s.toCharArray()) { // 문자열을 한 글자식 쪼개 char타입 배열로 변환
            int num = c - '0';

            if(num == 9)
            num = 6;

            arr[num]++;
        }

        arr[6] = arr[6]/2 + arr[6]%2;

        Arrays.sort(arr); // 배열 오름차순 정렬
        System.out.println(arr[arr.length-1]); // 각 자리의 수를 카운트하므로 맨 끝 배열 출력

    }
}
