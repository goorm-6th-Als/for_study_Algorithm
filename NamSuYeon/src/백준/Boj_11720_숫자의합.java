package 백준;

import java.util.Scanner;
public class Boj_11720_숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String str = sc.next();
        char[] chr = str.toCharArray();
        int sum = 0;

        for(int i = 0; i<a; i++){
            sum += Character.getNumericValue(chr[i]);
        }
        System.out.println(sum);
    }
}
