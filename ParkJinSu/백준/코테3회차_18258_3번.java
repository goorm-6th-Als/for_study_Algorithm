package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MulticastSocket;
import java.util.Stack;
import java.util.StringTokenizer;

public class 코테3회차_18258_3번 {
	
	static int front=0, back=0;
	static int arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		arr= new int[n];
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "pop":
				bw.append(pop()+"\n");
				break;
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "size":
				bw.append(size()+"\n");
				
				break;
			case "empty":
				bw.append(empty()+"\n");
				
				break;
			case "front":
				bw.append(front()+"\n");
				
				break;
			case "back":
				
				bw.append(back()+"\n");
				break;

			default:
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	static void push(int num) {
		arr[back] = num;
		back++;
	}
	static int pop() {
		if(front == back) return -1;
		return arr[front++];
	}
	static int size() {
		return back-front;
	}
	static int empty() {
		if(back== front) return 1;
		return 0;
	}
	static int front() {
		if(back!= front) return arr[front];
		return -1;
	}
	static int back() {
		if(back!= front) return arr[back-1];
		return -1;
	}

}