package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int result = bfs(n, k);
    System.out.print(result);
  }

  private static int bfs(int n, int k) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(n);
    int[] dist = new int[100_001];
    Arrays.fill(dist, -1);
    dist[n] = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur == k) return dist[k];

      int[] next = {cur - 1, cur + 1, cur * 2};

      for (int i : next) {
        if (isValid(i) && dist[i] == -1) {
          dist[i] = dist[cur] + 1;
          queue.add(i);
        }
      }
    }

    return -1;
  }

  private static boolean isValid(int position) {
    return position >= 0 && position <= 100_000;
  }
}
