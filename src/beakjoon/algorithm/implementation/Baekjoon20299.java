package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon20299 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int count = 0;
    StringBuilder sb = new StringBuilder();
    ArrayList<String> answer = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      boolean check = false;
      String[] arr = br.readLine().split(" ");
      int sum = 0;
      for (int j = 0; j < arr.length; j++) {
        if (Integer.parseInt(arr[j]) < l) {
          check = true;
          break;
        }
        sum += Integer.parseInt(arr[j]);
      }

      if (check) continue;
      if (sum < k) continue;
      count++;
      for (String s : arr) {
        sb.append(s).append(" ");
      }
    }

    System.out.println(count);
    System.out.println(sb.toString());
  }
}
