package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3055 {
  static int R, C, endX, endY;
  static char[][] forest;
  static int[][] beaver, water;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    forest = new char[R][C];
    beaver = new int[R][C];
    water = new int[R][C];
    Queue<int[]> beaverQueue = new LinkedList<>();
    Queue<int[]> waterQueue = new LinkedList<>();

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        forest[i][j] = line.charAt(j);
        beaver[i][j] = -1;
        water[i][j] = -1;

        if (forest[i][j] == '*') {
          waterQueue.offer(new int[]{i, j});
          water[i][j] = 0;
        } else if (forest[i][j] == 'S') {
          beaverQueue.offer(new int[]{i, j});
          beaver[i][j] = 0;
        } else if (forest[i][j] == 'D') {
          endX = i;
          endY = j;
        }
      }
    }

    spreadWater(waterQueue);
    int time = moveBeaver(beaverQueue);

    if (time == -1) System.out.print("KAKTUS");
    else System.out.print(time);
  }

  static void spreadWater(Queue<int[]> waterQueue) {
    while (!waterQueue.isEmpty()) {
      int[] cur = waterQueue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (isOutOfBounds(nx, ny)) continue;
        if (forest[nx][ny] == 'X') continue;
        if (forest[nx][ny] == 'D' || water[nx][ny] != -1) continue;

        water[nx][ny] = water[x][y] + 1;
        waterQueue.offer(new int[]{nx, ny});
      }
    }

  }

  static int moveBeaver(Queue<int[]> beaverQueue) {
    while (!beaverQueue.isEmpty()) {
      int[] cur = beaverQueue.poll();
      int x = cur[0];
      int y = cur[1];

      for (int k = 0; k < 4; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (isOutOfBounds(nx, ny)) continue;


        if (forest[nx][ny] == 'X') continue;
        if (forest[nx][ny] == '*' || beaver[nx][ny] != -1) continue;
        if (water[nx][ny] != -1 && water[nx][ny] <= beaver[x][y] + 1) continue;


        if (nx == endX && ny == endY) {
          return beaver[x][y] + 1;
        }

        beaver[nx][ny] = beaver[x][y] + 1;
        beaverQueue.offer(new int[]{nx, ny});
      }
    }
    return -1;
  }

  static boolean isOutOfBounds(int x, int y) {
    return x < 0 || y < 0 || x >= R || y >= C;
  }
}

