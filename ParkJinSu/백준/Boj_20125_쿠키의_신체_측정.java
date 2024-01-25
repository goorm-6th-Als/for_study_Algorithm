package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj_20125_쿠키의_신체_측정 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		char cookie[][] = new char[n][n];
		int heartY=0, heartX=0, lArm=0, rArm=0, lLeg=0, rLeg=0, lowerBack=0;
		int size=0;
		StringBuilder sb;
		for(int i=0; i<n;i++) {
			sb = new StringBuilder();
			sb.append(br.readLine());
			for(int j=0; j<n;j++) {
				cookie[i][j] = sb.charAt(j); 
			}
		}
		//heart
		for(int i=0; i<n;i++) {
			for(int j=0; j<n-1;j++) {
				if(cookie[i][j] == '*') {
					heartY = i+1;
					heartX = j;
					break;
				}
			}
			if(heartY > 0) break;
		}
		//lArm
		for(int i=heartY; i<n; i++) {
			for(int j=0; j<heartX;j++) {
				if(cookie[i][j] == '*') size++;
			}
			if(size == 0) break;
			lArm +=size;
			size=0;
		}
		//System.out.println("lArm = " + lArm);
		//rArm
		for(int i=heartY; i<n; i++) {
			for(int j=heartX+1; j<n; j++) {
				if(cookie[i][j] == '*')	size++;
				
			}
			if(size == 0) break;
			rArm +=size;
			size=0;
		}
		//System.out.println("rArm = " + rArm);
		
		//lowerBack
		for(int i=heartY+1;i<n;i++) {
			if(cookie[i][heartX] == '*') lowerBack++;
			else break;
		}
		//lLeg
		for(int i=heartY+lowerBack+1;i<n; i++) {
			for(int j=0;j<heartX;j++) {
				if(cookie[i][j] == '*') size++;
			}
			if(size == 0) break;
			lLeg += size;
			size=0;
		}
		//rLeg
		for(int i=heartY+lowerBack+1; i<n; i++) {
			for(int j=heartX+1; j<n; j++) {
				if(cookie[i][j] == '*') size++;
			}
			if(size == 0) break;
			rLeg += size;
			size = 0;
		}
		bw.append(++heartY + " " + ++heartX+"\n");	
		bw.append(lArm + " "+rArm + " "+lowerBack + " " + lLeg + " " + rLeg);
		bw.flush();
		bw.close();
		br.close();
	}
	

}