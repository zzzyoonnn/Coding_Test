package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon13423 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int n;
    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      // b - a = c - b
      // 2b - a = c;
      Arrays.sort(arr);
      HashSet<Integer> set = new HashSet<>();
      for (int i : arr) {
        set.add(i);
      }

      int result = 0;
      for (int i = 0; i < n; i++) {     // b
        for (int j = 0; j < i; j++) {   // a
          if (set.contains(arr[i] + arr[i] - arr[j])) result++;
        }
      }

      System.out.println(result);
    }
  }
}
