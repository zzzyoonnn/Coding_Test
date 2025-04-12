package beakjoon.algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16236 {
  static int N;
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
  static int[][] sea;

  private static class Position implements Comparable<Position> {
    int x, y, distance;

    public Position(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }

    @Override
    public int compareTo(Position o) {
      if (this.distance == o.distance) {
        if (this.x == o.x) {
          return this.y - o.y;
        } else {
          return this.x - o.x;
        }
      } else {
        return this.distance - o.distance;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    sea = new int[N][N];

    StringTokenizer st;
    int babyX = 0, babyY = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        sea[i][j] = Integer.parseInt(st.nextToken());

        if (sea[i][j] == 9) {
          babyX = i;
          babyY = j;
          sea[i][j] = 0;
        }
      }
    }

    int size = 2;
    int eat = 0;
    int distance = 0;

    while (true) {
      Position target = bfs(babyX, babyY, size);

      if (target == null) break;  // 더 이상 먹을 수 있는 물고기 없음

      distance += target.distance;
      babyX = target.x;
      babyY = target.y;
      sea[babyX][babyY] = 0;

      eat++;
      if (eat == size) {
        size++;
        eat = 0;
      }
    }

    System.out.println(distance);
  }

  // 가장 가까운 먹을 수 있는 물고기 한 마리 찾기
  private static Position bfs(int startX, int startY, int size) {
    int max = 0;
    boolean[][] visited = new boolean[N][N];
    Queue<Position> queue = new LinkedList<>();
    PriorityQueue<Position> fishes = new PriorityQueue<>();

    queue.offer(new Position(startX, startY, 0));
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      Position now = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now.x + dx[d];
        int ny = now.y + dy[d];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visited[nx][ny]) continue;
        if (sea[nx][ny] > size) continue;

        visited[nx][ny] = true;

        if (sea[nx][ny] != 0 && sea[nx][ny] < size) {
          fishes.offer(new Position(nx, ny, now.distance + 1));
        }

        queue.offer(new Position(nx, ny, now.distance + 1));
      }
    }

    if (fishes.isEmpty()) return null;
    return fishes.poll();
  }
}
