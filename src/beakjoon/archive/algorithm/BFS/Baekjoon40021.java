package beakjoon.archive.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon40021 {
  static int f, s, g, u, d;

  public static class Gangho {
    int location;
    int count;

    public Gangho(int location, int count) {
      this.location = location;
      this.count = count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    f = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    int result = bfs(s);

    if (result == -1) System.out.print("use the stairs");
    else System.out.print(result);
  }

  private static int bfs(int s) {
    Queue<Gangho> q = new LinkedList<>();
    q.add(new Gangho(s, 0));

    boolean[] visited = new boolean[f + 1];
    visited[s] = true;

    while (!q.isEmpty()) {
      Gangho cur = q.poll();
      int now = cur.location;
      if (now == g) {
        return cur.count;
      }

      if (now + u <= f && !visited[now + u]) {
        visited[now + u] = true;
        q.offer(new Gangho(now + u, cur.count + 1));
      }

      if (now - d >= 1 && !visited[now - d]) {
        visited[now - d] = true;
        q.offer(new Gangho(now - d, cur.count + 1));
      }
    }

    return -1;
  }
}
