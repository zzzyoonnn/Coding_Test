package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon1351 {
  static long N, P, Q;
  static HashMap<Long, Long> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Long.parseLong(st.nextToken());
    P = Long.parseLong(st.nextToken());
    Q = Long.parseLong(st.nextToken());

    map = new HashMap<>();
    map.put(0L, 1L);
    System.out.print(findAn(N));
  }

  private static long findAn(long n) {
    if (map.containsKey(n)) return map.get(n);

    long first = findAn((long)Math.floor(n / P));
    long second = findAn((long)Math.floor(n / Q));
    map.put(n, first + second);
    return first + second;
  }
}
