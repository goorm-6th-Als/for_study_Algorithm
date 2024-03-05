package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_2776_암기왕 {
    static int[] note;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int t = parseInt(br.readLine());
        int note1Len, note2Len;

        for(int i=0; i<t; i++){
            note1Len = parseInt(br.readLine());
            note = new int[note1Len];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<note1Len; j++){
                note[j] = parseInt(st.nextToken());

            }
            note2Len = parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Arrays.sort(note);
            for(int j=0; j<note2Len; j++){
                bw.append(bs(parseInt(st.nextToken()))+"\n");
            }


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
            else return 1;
        }


        return 0;
    }
}
