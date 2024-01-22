import java.io.*;
import java.util.*;

public class BOJ_20546_기적의_매매법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cash = Integer.parseInt(st.nextToken()); // 자본금 입력

        int JH_money = cash; // 준현 현금
        int SM_money = cash; // 성민 현금

        int up = 0; // 연속 상승
        int down = 0; // 연속 하락

        int JH_joo = 0; // 준현 주식 개수
        int SM_joo = 0; // 성민 주식 개수

        int[] arr = new int[14];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 주가 입력
        }

        // 준현의 최종 금액
        for (int i = 0; i < 14; i++) {
            if (JH_money >= arr[i]) {
                JH_joo += JH_money / arr[i];
                JH_money = JH_money % arr[i];
            }
        }

        // 성민의 최종 금액
        for (int i = 0; i < 14; i++) {
            if (i == 0) {
                continue;
            } else {
                if (arr[i] < arr[i - 1]) { // 전일 대비 하락 시
                    down++;
                    up = 0;
                } else if (arr[i] > arr[i - 1]) { // 전일 대비 상승 시
                    up++;
                    down = 0;
                } else { // 동일할 시
                    up = 0;
                    down = 0;
                }

                // 매수, 매도
                if (SM_money >= arr[i]) { // 보유 현금이 더 많아야 매수
                    if (down >= 3) { // 3일 연속 하락인 경우
                        SM_joo += SM_money / arr[i];
                        SM_money %= arr[i];
                    }
                }
                if (up >= 3) { // 3일 연속 상승인 경우
                    SM_money += SM_joo * arr[i];
                    SM_joo = 0;
                }
            }
        }

        int SM_final = SM_money + (arr[13] * SM_joo);
        int JH_final = JH_money + (arr[13] * JH_joo);

        if (SM_final > JH_final) {
            System.out.println("TIMING");
        } else if (JH_final > SM_final) {
            System.out.println("BNP");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
