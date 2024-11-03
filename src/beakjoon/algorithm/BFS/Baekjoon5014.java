package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5014 {
  static int f, s, g, u, d;
  static int[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    f = Integer.parseInt(st.nextToken());   // building's height
    s = Integer.parseInt(st.nextToken());   // gangho
    g = Integer.parseInt(st.nextToken());   // startlink
    u = Integer.parseInt(st.nextToken());   // up
    d = Integer.parseInt(st.nextToken());   // down

    visited = new int[f + 1];
    int result = bfs(s);

    if (result == -1) System.out.println("use the stairs");
    else System.out.println(result);
  }

  public static int bfs(int s) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    visited[s] = 1;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if (cur == g) {
        return visited[cur] - 1;
      }

      if (cur + u < visited.length && visited[cur + u] == 0) {
        visited[cur + u] = visited[cur] + 1;
        queue.add(cur + u);
      }

      if (cur - d > 0 && visited[cur - d] == 0) {
        visited[cur - d] = visited[cur] + 1;
        queue.add(cur - d);
      }
    }

    return -1;
  }
}
