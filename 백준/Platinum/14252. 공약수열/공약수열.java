
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      arr.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(arr);
    int count = 0;
    List<List<Integer>> arr2 = new ArrayList<>();

    for (int i = 0; i < arr.size() - 1; i++) {
      if (gcd(arr.get(i), arr.get(i + 1)) > 1) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr.get(i));
        temp.add(arr.get(i + 1));
        arr2.add(temp);
      }
    }

    for (List<Integer> integers : arr2) {
      int a = integers.get(0);
      int b = integers.get(1);
      for (int i = a + 1; i < b; i++) {
        int tmp = 0;
        if (gcd(a, i) == 1) tmp += 1;
        if (gcd(b, i) == 1) tmp += 1;
        if (tmp > 1) {
          count++;
          break;
        }
        if (i == b - 1) {
          count++;
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static int gcd(int a, int b) {
    while (a % b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;
    }
    return b;
  }
}
