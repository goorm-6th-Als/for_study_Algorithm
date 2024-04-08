package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Boj_1913_달팽이 {
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine());
		int snail[][]= new int[n][n]; 
		int y=0,x=0;
		int index = n*n;
		String target="";
		if(index == find) target = (y+1) +" " +(x+1);
		while(index >0) {
			y = x;
			while(y<n&&snail[y][x] == 0) {
				snail[y][x] = index--;
				y++;
			}
			y--;
			x++;
			while(x<n && snail[y][x] ==0) {
				snail[y][x] = index--;
				x++;
			}
			x--;
			y--;
			while(y>=0 && snail[y][x] ==0) {
				snail[y][x] = index--;
				y--;
			}
			y++;
			x--;
			while(x>0 &&snail[y][x] ==0) {
				snail[y][x] = index--;
				x--;
			}
			x++;
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n;j++) {
				if(snail[i][j] == find) target = (i+1) +" " +(j+1);
				bw.append(snail[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.append(target);
		bw.flush();
		bw.close();
		br.close();
	}
	

}