
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> arr;
    private static BufferedWriter bw;
    private static List<Integer> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        tmp = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        recur(0);
        bw.flush();
        bw.close();
    }

    private static void recur(int num) throws IOException {
        if (num == M) {
            for (int i = 0; i < M; i++) {
                bw.write(String.valueOf(tmp.get(i)));
                if (i != M - 1) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {

            tmp.add(arr.get(i));
            recur(num + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}