package beakjoon.step_by_step.stage_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10813 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];
    for (int i = 1; i <= n; i++) arr[i] = i;

    for (int a = 1; a <= m; a++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");
    System.out.print(sb);
  }
}
