package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon23827 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 수열의 길이
    long MOD = 1000000007;

    ArrayList<Long> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    list.add(0l);
    for (int i = 1; i <= n; i++) list.add(Long.parseLong(st.nextToken()));
    long[] prefixSum = new long[n+2];
    for (int i = n; i >= 1; i--) {
      prefixSum[i] += prefixSum[i+1] + list.get(i);
    }
    long sum = 0l;
    for (int i = 1; i <= n; i++) {
      sum += list.get(i) * prefixSum[i+1];
      sum %= MOD;
    }
    System.out.println(sum);
  }
}