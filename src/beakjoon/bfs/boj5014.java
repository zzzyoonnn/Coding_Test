package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
  static int f, s, g, u, d, count;
  static int[] building;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    f = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    building = new int[f + 1];
    Arrays.fill(building, -1);

    int result = bfs(s);

    System.out.print(result == -1 ? "use the stairs" : result);
  }

  private static int bfs(int index) {
    building[index] = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (now == g) return building[g];

      // 위로 이동
      if (now + u <= f  && building[now + u] == -1) {
        building[now + u] = building[now] + 1;
        queue.add(now + u);
      }

      // 아래로 이동
      if (now - d > 0 && building[now - d] == -1) {
        building[now - d] = building[now] + 1;
        queue.add(now - d);
      }
    }

    return -1;
  }
}
