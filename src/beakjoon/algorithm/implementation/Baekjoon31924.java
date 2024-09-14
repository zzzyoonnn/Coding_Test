package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon31924 {
  static int n;
  static int count = 0;
  static char[][] words;
  static int index = 0;
  static char[] mobis = {'M', 'O', 'B', 'I', 'S'};
  static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1},
                dy = {1, -1, 0, 0, 1, -1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    words = new char[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      words[i] = s.toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (words[i][j] == mobis[0]) {
          for (int dir = 0; dir < 8; dir++) {
            dfs(i, j, dir);
          }
        }
      }
    }
    System.out.println(count);

  }

  private static void dfs(int x, int y, int dir) {

    if (index == 4) {
      count++;
      return;
    }

    int nx = x + dx[dir];
    int ny = y + dy[dir];

    if (nx >= 0 && nx < n && ny >= 0 && ny < n && words[nx][ny] == mobis[index + 1]) {
      index++;
      dfs(nx, ny, dir);
      index--;
    }
  }
}
