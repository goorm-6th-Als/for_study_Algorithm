package baekjoon;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Boj_11725_트리의_부모_찾기 {
    static Map<Integer,List<Integer>> map;
    static int[] parentList;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =parseInt(br.readLine());
        StringTokenizer st;
        map = new HashMap<>(); // 숫자 i와 연결될 리스트를 담을 HashMap
        int nodeA, nodeB; // 입력받을 노드
        parentList = new int[n+1]; // i의 부모
        visit =new boolean[n+1]; // 가정방문 여부
        List<Integer> tmp; //임시 리스트
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            nodeA = parseInt(st.nextToken());
            nodeB = parseInt(st.nextToken());

            tmp = map.getOrDefault(nodeA , new ArrayList<>());
            tmp.add(nodeB);
            map.put(nodeA, tmp);

            tmp = map.getOrDefault(nodeB , new ArrayList<>());
            tmp.add(nodeA);
            map.put(nodeB, tmp);

        }

        findParent(1);
        for (int i = 2; i < n+1; i++) {
            bw.append(parentList[i] +"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void findParent(int target){
        if(visit[target]) return;
        visit[target] =true;
        for (Integer i : map.get(target)) {
            if(parentList[i] == 0)parentList[i] = target;
            findParent(i);
        }


    }

}
