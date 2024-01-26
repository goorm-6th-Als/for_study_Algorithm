import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] square = new String[n];

        for (int i = 0; i < n; i++) {
            square[i] = br.readLine();

        }

        int[] asw = new int[5]; //왼팔, 오른팔, 허리, 왼다리, 오른다리
        int[] heart = new int[2];

        loop1:
        //첫번째 나온 *(머리)에서 심장 위치 초기화
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) {
                if (square[i].charAt(j) == '*') {
                    heart[0] = i + 2;  //머리보다 아래로 한칸 아래
                    heart[1] = j + 1;
                    break loop1;
                }
            }
        }

        int cnt = 0;
        //왼팔
        for (int i = heart[1] - 2; i >= 0; i--) {
            if (square[heart[0] - 1].charAt(i) == '*') {
                cnt++;
            } else if (square[heart[0] - 1].charAt(i) == '_') {
                break;
            }
        }
        asw[0] = cnt;
//        System.out.println("왼팔 : " + asw[0]);

        cnt = 0;
        //오른팔
        for (int i = heart[1]; i < n; i++) {
            if (square[heart[0] - 1].charAt(i) == '*') {
                cnt++;
            } else if (square[heart[0] - 1].charAt(i) == '_') {
                break;
            }
        }
        asw[1] = cnt;
//        System.out.println("오른팔 : " + asw[1]);

        //허리
        cnt = 0;
        for (int i = heart[0]; i < n; i++) {
            if (square[i].charAt(heart[1] - 1) == '*') {
                cnt++;
            } else if (square[i].charAt(heart[1] - 1) == '_') {
                break;
            }
        }
        asw[2] = cnt;
//        System.out.println("허리 : " + asw[2]);

        //왼다리
        cnt = 0;
        for (int i = heart[0] + asw[2]; i < n; i++) {
            if (square[i].charAt(heart[1] - 2) == '*') {
                cnt++;
            } else if (square[i].charAt(heart[1] - 2) == '_') {
                break;
            }
        }
        asw[3] = cnt;
//        System.out.println("왼다리 : " + asw[3]);

        //오른쪽다리
        cnt = 0;
        for (int i = heart[0] + asw[2]; i < n; i++) {
            if (square[i].charAt(heart[1]) == '*') {
                cnt++;
            } else if (square[i].charAt(heart[1]) == '_') {
                break;
            }
        }
        asw[4] = cnt;
//        System.out.println("오른다리 : " + asw[4]);

        for (int i : heart) {
            bw.write(i + " ");
        }
        bw.newLine();

        for (int i : asw) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();

    }
}