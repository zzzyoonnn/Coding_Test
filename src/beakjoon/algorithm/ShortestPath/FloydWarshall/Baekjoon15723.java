package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    boolean[][] arr = new boolean[26][26];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = st.nextToken().charAt(0) - 'a';
      st.nextToken();
      int b = st.nextToken().charAt(0) - 'a';

      arr[a][b] = true;
    }

    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (i == j || i == k || j == k) continue;
          if (!arr[i][j] && arr[i][k] && arr[i][k] == arr[k][j]) {
            arr[i][j] = true;
          }
        }
      }
    }

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = st.nextToken().charAt(0) - 'a';
      st.nextToken();
      int b = st.nextToken().charAt(0) - 'a';

      if (arr[a][b]) System.out.println("T");
      else System.out.println("F");
    }
  }
}
