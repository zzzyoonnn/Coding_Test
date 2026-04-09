package beakjoon.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205 {

  public static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      int hx = Integer.parseInt(st.nextToken());
      int hy = Integer.parseInt(st.nextToken());

      Point home = new Point(hx, hy);

      Point[] stores = new Point[n];

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        stores[i] = new Point(a, b);
      }

      st = new StringTokenizer(br.readLine());
      int fx = Integer.parseInt(st.nextToken());
      int fy = Integer.parseInt(st.nextToken());

      Point festival = new Point(fx, fy);

      Queue<Point> queue = new LinkedList<>();
      boolean[] visited = new boolean[n];

      queue.add(home);

      boolean result = false;
      while (!queue.isEmpty()) {
        Point cur = queue.poll();

        if (dist(cur, festival) <= 1000) {
          result = true;
          break;
        }

        for (int i = 0; i < n; i++) {
          if (!visited[i] && dist(cur, stores[i]) <= 1000) {
            visited[i] = true;
            queue.add(stores[i]);
          }
        }
      }
      System.out.println(result ? "happy" : "sad");
    }

  }

  private static int dist(Point a, Point b) {
    return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
  }
}
