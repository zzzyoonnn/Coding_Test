package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5427 {
  static int w, h;
  static char[][] map;
  static int[][] fireTime, personTime;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      map = new char[h][w];
      fireTime = new int[h][w];
      personTime = new int[h][w];
      Queue<int[]> fireQueue = new LinkedList<>();
      Queue<int[]> personQueue = new LinkedList<>();

      for (int i = 0; i < h; i++) {
        String line = br.readLine();
        for (int j = 0; j < w; j++) {
          map[i][j] = line.charAt(j);
          fireTime[i][j] = -1;
          personTime[i][j] = -1;

          if (map[i][j] == '*') {
            fireQueue.offer(new int[]{i, j});
            fireTime[i][j] = 0;
          } else if (map[i][j] == '@') {
            personQueue.offer(new int[]{i, j});
            personTime[i][j] = 0;
          }
        }
      }

      spreadFire(fireQueue);
      int escapeTime = movePerson(personQueue);

      if (escapeTime == -1) sb.append("IMPOSSIBLE\n");
      else sb.append(escapeTime).append("\n");
    }
    System.out.print(sb);
  }

  static void spreadFire(Queue<int[]> fireQueue) {
    while (!fireQueue.isEmpty()) {
      int[] cur = fireQueue.poll();
      int x = cur[0], y = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
        if (map[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

        fireTime[nx][ny] = fireTime[x][y] + 1;
        fireQueue.offer(new int[]{nx, ny});
      }
    }
  }

  static int movePerson(Queue<int[]> personQueue) {
    while (!personQueue.isEmpty()) {
      int[] cur = personQueue.poll();
      int x = cur[0], y = cur[1];

      if (x == 0 || y == 0 || x == h - 1 || y == w - 1) {
        return personTime[x][y] + 1;
      }

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d], ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
        if (map[nx][ny] == '#' || personTime[nx][ny] != -1) continue;
        if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= personTime[x][y] + 1) continue; // 불이 먼저 도착한 곳이면 이동 불가

        personTime[nx][ny] = personTime[x][y] + 1;
        personQueue.offer(new int[]{nx, ny});
      }
    }
    return -1;
  }
}