package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon20299 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int count = 0;
    ArrayList<String> answer = new ArrayList<String>();
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split(" ");
      int sum = 0;
      for (int j = 0; j < arr.length; j++) {
        if (Integer.parseInt(arr[j]) < l) break;
        sum += Integer.parseInt(arr[j]);
      }

      if (sum >= k) {
        count++;
        for (String s : arr) {
          answer.add(s);
        }
      }
    }

    System.out.println(count);
    for (int i = 0; i < answer.size(); i++) {
      System.out.print(answer.get(i) + " ");
    }
  }
}
