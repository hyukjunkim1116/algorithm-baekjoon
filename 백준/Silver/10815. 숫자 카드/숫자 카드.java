import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int[] arr1 = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      arr1[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr1);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < m; i++) {
      int number = Integer.parseInt(st.nextToken());

      int s = 0;
      int e = n - 1;
      boolean check = false;

      while(s <= e) {
        int mid = (s + e) / 2;
        if(arr1[mid] == number) {
          check = true;
          break;
        } else if(arr1[mid] > number) {
          e = mid - 1;
        } else {
          s = mid + 1;
        }
      }

      sb.append(check ? 1 : 0).append(" ");
    }

    System.out.println(sb);
  }
}
