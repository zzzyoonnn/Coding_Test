package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3985 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int l = Integer.parseInt(br.readLine());    // 롤 케이크의 길이
    int n = Integer.parseInt(br.readLine());    // 방청객의 수

    int expectation = 0;
    int expetationNum = 0;
    int result = 0;
    int resultNum = 0;

    StringTokenizer st;
    boolean[] arr = new boolean[l + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      int p = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      if (expectation < k - p + 1) {
        expectation = k - p + 1;
        expetationNum = i;
      }

      int count = 0;
      for (int j = p; j <= k; j++) {
        if (!arr[j]) {
          count++;
          arr[j] = true;
        }
      }

      if (result < count) {
        result = count;
        resultNum = i;
      }
    }

    System.out.println(expetationNum);
    System.out.println(resultNum);
  }
}
