package beakjoon.algorithm.eratos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon19699 {
  static int n, m;
  static boolean[] isNotPrime;
  static int[] cow;
  static ArrayList<Integer> result;

  public static void main(String[] args) throws IOException {
    setData();

    backTracking(0, 0, 0);

    System.out.print(printResult());
  }

  private static String printResult() {
    StringBuilder sb = new StringBuilder();

    Collections.sort(result);
    for (int i : result) {
      sb.append(i).append(" ");
    }

    if (sb.toString().isEmpty()) return "-1";
    else return sb.toString();
  }

  private static void backTracking(int now, int sum, int count) {
    if (count == m) {
      if (!isNotPrime[sum] && !result.contains(sum)) result.add(sum);
    }

    for (int i = now; i < n; i++) {
      backTracking(i + 1, sum + cow[i], count + 1);
    }
  }

  private static boolean[] eratos() {
    boolean[] isNotPrime = new boolean[1_000_001];
    isNotPrime[0] = isNotPrime[1] = true;

    for (int i = 2; i * i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) {
        for (int j = i * i; j < isNotPrime.length; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    return isNotPrime;
  }

  private static void setData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());   // 농장에 있는 소들의 수
    m = Integer.parseInt(st.nextToken());   // 선별할 소

    cow = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cow[i] = Integer.parseInt(st.nextToken());
    }

    isNotPrime = eratos();
    result = new ArrayList<>();
  }
}
