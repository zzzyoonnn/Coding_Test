package beakjoon.archive.algorithm.DepthFirstSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
  static int N, M;
  static int[][] box;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static Queue<Tomato> q;

  public static class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    box = new int[N][M];
    q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());

        if (box[i][j] == 1) q.offer(new Tomato(i, j));
      }
    }

    while (!q.isEmpty()) {
      Tomato tomato = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = tomato.x + dx[k];
        int ny = tomato.y + dy[k];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
          box[nx][ny] = box[tomato.x][tomato.y] + 1;
          q.add(new Tomato(nx, ny));
        }
      }
    }

    int max = -1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 0) {
          System.out.print(-1);
          return;
        }

        max = Math.max(max, box[i][j]);
      }
    }
    System.out.print(max - 1);
  }
}
