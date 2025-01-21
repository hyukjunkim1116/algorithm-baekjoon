
  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.OutputStreamWriter;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.StringTokenizer;

  public class Main {
    private static int N;
    private static int M;
    private static List<Integer> arr;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      arr = new ArrayList<>();
      recur(0);
      bw.flush();
      bw.close();
    }

    private static void recur(int number) throws IOException {
      if (number == M) {
        for (int i = 0; i < M; i++) {
          bw.write(String.valueOf(arr.get(i)));
          if (i != M - 1) {
            bw.write(" ");
          }
        }
        bw.write("\n");
        return;
      }
      for (int i = 1; i < N + 1; i++) {
        arr.add(i);
        recur(number + 1);
        arr.remove(arr.size() - 1);
      }
    }
  }
