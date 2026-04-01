package beakjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[][] grid = new boolean[26][26];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = st.nextToken().charAt(0) - 'a';
      st.nextToken();
      int b = st.nextToken().charAt(0) - 'a';

      grid[a][b] = true;
    }

    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (grid[i][k] && grid[k][j]) grid[i][j] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = st.nextToken().charAt(0) - 'a';
      st.nextToken();
      int b = st.nextToken().charAt(0) - 'a';

      if (grid[a][b]) sb.append("T");
      else sb.append("F");
      sb.append('\n');
    }
    System.out.print(sb);
  }
}
