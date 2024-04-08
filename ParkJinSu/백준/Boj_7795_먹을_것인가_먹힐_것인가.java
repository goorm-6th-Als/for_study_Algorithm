package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_7795_먹을_것인가_먹힐_것인가 {
    static int[] note;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer;
        StringTokenizer st;
        int t = parseInt(br.readLine());
        int note1Len, note2Len;

        for(int i=0; i<t; i++){
            answer=0;
            st = new StringTokenizer(br.readLine());
            note1Len = parseInt(st.nextToken());
            note2Len = parseInt(st.nextToken());
            note = new int[note1Len];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<note1Len; j++){
                note[j] = parseInt(st.nextToken());

            }
            st = new StringTokenizer(br.readLine());
            Arrays.sort(note);
            for(int j=0; j<note2Len; j++){
                answer += bs(parseInt(st.nextToken()));
            }
            bw.append(answer +"\n");
        }
    bw.flush();
    bw.close();
    br.close();
    }

    static int bs(int num){
        int left=0;
        int right = note.length-1;
        int mid;
        while(left <= right){
            mid = (left+ right)/2;
            if(note[mid] > num) right = mid-1;
            else if(note[mid] < num) left = mid+1;
            else {
                return check(mid, num);
            }
        }

        return note.length-left;
    }
    static int check(int mid, int num){
        if(mid >= note.length-1 || note[mid+1] != note[mid]) return note.length-mid-1;
        return check(mid+1, num);
    }

}
