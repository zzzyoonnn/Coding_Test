package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17176 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      //System.out.println((char)('A' + num - 1));
      char c = (char)('A' + num - 1);
      System.out.println(c);

      if (num == 0) sb.append(' ');
      else if (num >= 1 && num <= 26) {
        System.out.println((char)('A' + num - 1));
        sb.append((char)(num + 'A' - 1));
      }
      else {
        System.out.println((char)('a' + num - 1));
        sb.append((char)(num + 'a' - 1));
      }
    }

    System.out.println(sb);
  }
}
