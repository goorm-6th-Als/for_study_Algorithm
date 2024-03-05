package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] isChecked = new int[10];
        String[] number = br.readLine().split("");
        int max = 0;

        for(int i = 0; i<number.length; i++){
            isChecked[Integer.parseInt(number[i])] +=1;
            max = Math.max(max,isChecked[Integer.parseInt(number[i])]);
        }

        if (max == isChecked[6] || max == isChecked[9]){
            // int / int 에서는 정수까지만 나누고 나누지 않느다.
            // 따라서 6이 3이고 9가 4일 경우 (3 + 4) /2 의 결과 값은 3이다
            // 3을 올림을 해도 2이기 때문에 Math.ceil함수는 필요가 없다.
            // max = (int)Math.ceil((isChecked[6] + isChecked[9])/2);
            // 위의 코드는 max에 3이 들어간 6의 갯수나 9의 갯수 중에 하나를 강제로 형변황을 해주어햐 한다.
            max = (int)Math.ceil((isChecked[6] + (double)isChecked[9])/2);
            isChecked[6] = max;
            isChecked[9] = max;
        }

        for(int i = 0; i<isChecked.length; i++){
            max = Math.max(max, isChecked[i]);
        }

        System.out.println(max);
    }
}
