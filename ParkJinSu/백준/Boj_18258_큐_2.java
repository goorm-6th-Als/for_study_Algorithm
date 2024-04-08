package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_18258_큐_2{

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] command;
		int front=0, rear=0;
		int n = Integer.parseInt(br.readLine());
		Integer q[] = new Integer[2000000];
		for(int i=0; i<n; i++) {
			
			command = br.readLine().split(" ");
			switch (command[0]) {
			case "push":
				
				q[rear] = Integer.parseInt(command[1]);
				rear++;
				break;
			case "front":
				if(front == rear) {
					bw.append("-1\n");
				}else {
					bw.append(q[front]+"\n");
				}
				break;
			case "back":
				if(front == rear) {
					bw.append("-1\n");
				}else {
					bw.append(q[rear-1]+"\n");
				}
				break;
			case "size":
				bw.append((rear - front)+"\n");
				break;
			case "empty":
				if(rear == front) bw.append(1+"\n");
				else bw.append(0+"\n");
				break;
			case "pop":
				if(rear>front) {
					bw.append(q[front]+"\n");
					front++;
				}
				else bw.append(-1+"\n");
				break;
			default:
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}