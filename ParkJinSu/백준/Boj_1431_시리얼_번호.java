package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_1431_시리얼_번호{

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length())return -1;
				else if(o1.length() == o2.length()) {
					int tmp = Integer.compare(intFilter(o1),intFilter(o2));
					if(tmp == 0) {
						return o1.compareTo(o2);
						
					}else return tmp; 
				}else {
					return 1;
				}
			}
		});
		for(String a : arr) {
			System.out.println(a);
		}
		
		br.close();
	}
	
	static int intFilter(String str) {
		int sum=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>'0' && str.charAt(i) <= '9') {
				sum += (str.charAt(i)-'0');
			}
		}
		
		return sum;
	}

	static void print(String msg) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append(msg);
		bw.flush();
		bw.close();
	}

}