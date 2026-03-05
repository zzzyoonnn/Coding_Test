package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10811 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];
    for (int k = 1; k <= n; k++) arr[k] = k;

    int i, j, temp;
    for (int a = 0; a < m; a++) {
      st = new StringTokenizer(br.readLine());
      i = Integer.parseInt(st.nextToken());
      j = Integer.parseInt(st.nextToken());

      for (int b = 0; b <= (j - i) / 2; b++) {
        temp = arr[i + b];
        arr[i + b] = arr[j - b];
        arr[j - b] = temp;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int a = 1; a <= n; a++) sb.append(arr[a]).append(" ");
    System.out.print(sb);
  }
}
