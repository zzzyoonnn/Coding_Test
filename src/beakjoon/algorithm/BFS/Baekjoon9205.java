package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon9205 {
  static int t, n;
  static boolean result;
  static int startX = 0, startY = 0, endX = 0, endY = 0;
  static ArrayList<int[]> stores;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      result = false;
      n = Integer.parseInt(br.readLine());  // 편의점 개수

      st = new StringTokenizer(br.readLine());

      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());

      stores = new ArrayList<>();
      for (int ni = 0; ni < n; ni++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        stores.add(new int[]{x, y});
      }

      visited = new boolean[n];

      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      visited = new boolean[n];
      bfs();

      System.out.println(result ? "happy" : "sad");
    }

  }

  private static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startX, startY});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      if (Math.abs(endX - nowX) + Math.abs(endY - nowY) <= 1000) {
        result = true;
        return;
      }

      for (int i = 0; i < stores.size(); i++) {
        if (visited[i]) continue;

        int[] store = stores.get(i);
        int storeX = store[0];
        int storeY = store[1];

        int distance = Math.abs(storeX - nowX) + Math.abs(storeY - nowY);
        if (distance <= 1000) {
          queue.add(new int[]{storeX, storeY});
          visited[i] = true;
        }
      }
    }

  }
}
