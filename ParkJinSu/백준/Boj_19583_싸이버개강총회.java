package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(st.nextToken(), ":");
        int startTime = (60 * parseInt(st1.nextToken())) + parseInt(st1.nextToken())+1;
        st1 = new StringTokenizer(st.nextToken(), ":");
        int checkTime = (60 * parseInt(st1.nextToken())) + parseInt(st1.nextToken())-1;
        st1 = new StringTokenizer(st.nextToken(), ":");
        int endTime = (60 * parseInt(st1.nextToken())) + parseInt(st1.nextToken())+1;

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        int answer = 0;
        String chat;
        int chatTime;
        String chatName;
        while((chat = br.readLine()) != null && !chat.isEmpty()){
            st = new StringTokenizer(chat);
            st1 = new StringTokenizer(st.nextToken(), ":");
            chatTime= (60 * parseInt(st1.nextToken())) + parseInt(st1.nextToken());
            chatName = st.nextToken();
            if(chatTime < startTime){
                before.add(chatName);
            }else if(checkTime < chatTime && chatTime < endTime && before.contains(chatName)){
                after.add(chatName);
            }
        }



        bw.append(after.size()+"");
        bw.flush();
        bw.close();
        br.close();

    }




}
