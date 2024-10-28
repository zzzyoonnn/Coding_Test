package beakjoon.algorithm.implementation;

import beakjoon.algorithm.ShortestPath.Baekjoon16958;

import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon28215 {
  static int n, k;
  static List<Integer> x, y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // 집 수
    k = Integer.parseInt(st.nextToken());   // 대피소 수

    x = new ArrayList<>();
    y = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      x.add(Integer.parseInt(st.nextToken()));
      y.add(Integer.parseInt(st.nextToken()));
    }

    System.out.print(solve());
  }

  private static int calculateDistance(int a, int b, int c) {
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int dist = Math.min(
              Math.abs(x.get(i) - x.get(a)) + Math.abs(y.get(i) - y.get(a)),
              Math.min(
                      Math.abs(x.get(i) - x.get(b)) + Math.abs(y.get(i) - y.get(b)),
                      Math.abs(x.get(i) - x.get(c)) + Math.abs(y.get(i) - y.get(c))
              )
      );
      ans = Math.max(ans, dist);
    }
    return ans;
  }
  private static int solve() {
    int ans = Integer.MAX_VALUE;

    if (k == 1) {
      for (int i = 0; i < n; i++) {
        ans = Math.min(ans, calculateDistance(i, i, i));
      }
    } else if (k == 2) {
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          ans = Math.min(ans, calculateDistance(i, j, j));
        }
      }
    } else if (k == 3) {
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          for (int m = j; m < n; m++) {
            ans = Math.min(ans, calculateDistance(i, j, m));
          }
        }
      }
    }
    return ans;
  }
}
