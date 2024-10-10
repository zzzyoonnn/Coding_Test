package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5026 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // the number of questions

    String s;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      s = br.readLine();

      if (s.equals("P=NP")) {
        sb.append("skipped");
      } else {
        String[] arr = s.split("\\+");
        int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
        sb.append(String.valueOf(sum));
      }
      sb.append("\n");
    }

    System.out.print(sb.toString());
  }
}
