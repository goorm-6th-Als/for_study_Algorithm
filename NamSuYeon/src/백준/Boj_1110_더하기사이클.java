package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1110_더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int wanted = number;
        int cycleOfNumber = 0;

        do{
            cycleOfNumber++;
            int leftNum = number/10;
            int rightNum = number%10;
            int addNum = leftNum + rightNum;
            int addNumRight = addNum%10;
            number = rightNum *10 +addNumRight;
        }while (number != wanted);

        System.out.println(cycleOfNumber);
    }
}
