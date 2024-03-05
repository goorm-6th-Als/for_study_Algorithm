import java.util.*;
import java.io.*;

public class Main {// Boj_1475_방번호
	
	static String N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = br.readLine();
		char a [] = {'0','1','2','3','4','5','6','7','8','9'};
		int arr [] = new int [10];
		for(int i = 0; i<N.length(); i++) {
			for(int j = 0; j<a.length; j++) {
				char c = N.charAt(i);
				if(c == a[j]) {
					arr[j] ++;
					break;
				}
			}
		}
		int nine_six = arr[6] + arr[9];
		if(nine_six % 2 == 0) {
			arr[6] = nine_six/2;
			arr[9] = nine_six/2;
		}else {
			arr[6] = nine_six/2+1;
			arr[9] = nine_six/2+1;
		}
		System.out.println("6: "+arr[6]);
		System.out.println("9: "+arr[9]);
		Arrays.sort(arr);
		int length = arr.length;
		System.out.println(arr[length-1]);
	}
}