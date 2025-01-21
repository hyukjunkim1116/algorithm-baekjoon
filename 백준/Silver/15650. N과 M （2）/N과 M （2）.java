

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer> arr;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        recur(1,0);
    }

    private static void recur(int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i));
                if (i != arr.size() - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }

        for(int i = start; i < N+1; i++) {
            arr.add(i);
            recur(i+1, depth+1);
            arr.remove(arr.size()-1);
        }
    }
}