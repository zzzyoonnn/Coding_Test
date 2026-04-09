package beakjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2589 {
  static int row, col, result;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  public static class Pos {
    int x, y, time;

    public Pos(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());

    map = new char[row][col];

    for (int i = 0; i < row; i++) {
      map[i] = br.readLine().toCharArray();
    }

    result = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (map[i][j] == 'L') {
          result = Math.max(result, bfs(i, j));
        }
      }
    }

    System.out.print(result);
  }

  private static int bfs(int x, int y) {
    visited = new boolean[row][col];
    Queue<Pos> queue = new LinkedList<>();
    queue.add(new Pos(x, y, 0));
    visited[x][y] = true;

    int time = 0;

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      for (int k = 0; k < 4; k++) {
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];
        int nTime = cur.time;

        time = Math.max(time, nTime);

        if (isInBounds(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
          visited[nx][ny] = true;
          queue.add(new Pos(nx, ny, nTime + 1));
        }
      }
    }

    return time;
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < row && y >= 0 && y < col;
  }
}
