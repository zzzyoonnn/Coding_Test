package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14248 {
  static int n, s;
  static int[] stones;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    stones = new int[n];
    visited = new boolean[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      stones[i] = Integer.parseInt(st.nextToken());
    }

    s = Integer.parseInt(br.readLine());
    bfs(s - 1);

    int result = 0;
    for (int i = 0 ; i < n ; i++) {
      if (visited[i]) result++;
    }

    System.out.print(result);
  }

  public static void bfs(int index) {
    visited[index] = true;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur + stones[cur] < stones.length && !visited[cur + stones[cur]]) {
        visited[cur + stones[cur]] = true;
        queue.add(cur + stones[cur]);
      }

      if (cur - stones[cur] >= 0 && !visited[cur - stones[cur]]) {
        visited[cur - stones[cur]] = true;
        queue.add(cur - stones[cur]);
      }
    }
  }
}
