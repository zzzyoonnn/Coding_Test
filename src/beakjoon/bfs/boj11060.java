package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11060 {
  static int n;
  static int[] maze, result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    maze = new int[n];
    result = new int[n];
    Arrays.fill(result, -1);

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) maze[i] = Integer.parseInt(st.nextToken());

    bfs(0);

    System.out.print(result[n - 1]);
  }

  private static void bfs(int index) {
    result[index] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(index);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (result[now] == n) return;

      for (int i = 1; i <= maze[now]; i++) {
        if (now + i < n && result[now + i] == -1) {
          result[now + i] = result[now] + 1;
          queue.add(now + i);
        }
      }
    }
  }
}
