import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int computer = Integer.parseInt(br.readLine());
    int connection = Integer.parseInt(br.readLine());

    // 그래프 초기화
    ArrayList<Integer>[] graph = new ArrayList[computer + 1];
    for (int i = 0; i <= computer; i++) {
      graph[i] = new ArrayList<>();
    }

    // 방문 배열 초기화
    boolean[] visited = new boolean[computer + 1];

    // 그래프 연결 정보 입력
    for (int i = 0; i < connection; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    // BFS 구현
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    visited[1] = true;

    while (!q.isEmpty()) {
      int k = q.poll();
      for (int i : graph[k]) {
        if (!visited[i]) {
          visited[i] = true;
          q.offer(i);
        }
      }
    }

    // 감염된 컴퓨터 수 계산
    int count = 0;
    for (boolean v : visited) {
      if (v) count++;
    }

    System.out.println(count - 1);
  }
}
