import java.util.*;
import java.io.*;

public class Main {// Boj_2309_일곱 난쟁이
	static int N, M;
	static int [] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		arr = new int [9];
		int sum = 0;
		for(int i = 0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int temp = sum - 100;		
		loop : for(int i=1; i<9; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[i] + arr[j] == temp) {
					System.out.println(arr[i] + " " + arr[j] + " " + temp);
					arr[i] = 101;
					arr[j] = 101;
					break loop;
				}
			}
		}
		
		Arrays.sort(arr);
		for(int i = 0; i<7; i++) {
			System.out.println(arr[i]);
		}
	}
}
