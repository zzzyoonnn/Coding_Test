package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {
  static int tc, l, startX, startY, endX, endY;
  static boolean[][] visited;
  static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
  static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

  private static class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    tc = Integer.parseInt(br.readLine()); // 테스트 케이스

    for (int i = 0; i < tc; i++) {
      l = Integer.parseInt(br.readLine());  // 한 변의 길이
      visited = new boolean[l][l];

      StringTokenizer st = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(st.nextToken());
      startY = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      int answer = bfs(startX, startY, 0);

      System.out.println(answer);
    }
  }

  private static int bfs(int x, int y, int count) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y, 0));
    visited[x][y] = true;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == endX && cur.y == endY) {
        return cur.count;
      }

      for (int k = 0; k < 8; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
          visited[nx][ny] = true;
          q.offer(new Node(nx, ny, cur.count + 1));
        }
      }
    }

    return -1;
  }

}
