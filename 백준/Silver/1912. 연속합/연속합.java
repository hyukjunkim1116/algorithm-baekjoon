
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int A = Integer.parseInt(br.readLine());
    List<Integer> inputList = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < A; i++) {
      inputList.add(Integer.parseInt(st.nextToken()));
    }

    List<Integer> prefix = new ArrayList<>();
    for (int i = 0; i < A + 1; i++) {
      prefix.add(-1001);
    }

    for (int i = 0; i < A; i++) {
      prefix.set(i + 1, Math.max(prefix.get(i) + inputList.get(i), inputList.get(i)));
    }

    Collections.sort(prefix);
    System.out.println(prefix.get(prefix.size() - 1));
  }
}
