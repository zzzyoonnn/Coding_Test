package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon20157 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 풍선의 개수

    HashMap<Double, Integer> map = new HashMap<>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());     // 풍선의 x좌표
      int y = Integer.parseInt(st.nextToken());     // 풍선의 y좌표

      if (x == 0 && y == 0) continue;

      double fraction = (double)gcd(x, y) / lcm(x, y);
      map.put(fraction, map.getOrDefault(fraction, 0) + 1);
    }

    int max = -1;
    for (double d : map.keySet()) {
      max = Math.max(max, map.get(d));
    }

    System.out.println(max);
  }

  public static int gcd(int x, int y) {
    if (y == 0) return 1;
    if (x % y == 0) return y;

    return gcd(y, x % y);
  }

  public static int lcm(int x, int y) {
    return x * y / gcd(x, y);
  }
}
