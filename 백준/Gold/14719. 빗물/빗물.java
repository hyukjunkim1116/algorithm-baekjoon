
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");


    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine()," ");

    List<Integer> heightList = new ArrayList<>();
    for(int i = 0; i < W; i++) {
      heightList.add(Integer.parseInt(st.nextToken()));
    }

    int answer = 0;
    for (int i = 0; i < W-1; i++) {
      int leftMax = 0;
      for (int j = 0; j < i; j++) {
        leftMax = Math.max(leftMax, heightList.get(j));
      }

      int rightMax = 0;
      for (int j = i + 1; j < heightList.size(); j++) {
        rightMax = Math.max(rightMax, heightList.get(j));
      }

      int water = Math.min(leftMax, rightMax) - heightList.get(i);
      if (water > 0) {
        answer += water;
      }


    }
    System.out.println(answer);
  }
}