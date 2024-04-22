package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon17122 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());
      boolean b1 = true;    // white
      boolean b2 = true;    // white
      String first = st.nextToken();
      int i1 = first.charAt(0) - 'A' + 1;
      int i2 = first.charAt(1) - '0';

      if (i1 % 2 != 0) {    // 첫 시작이 검정이라면
        if (i2 % 2 != 0) b1 = false;
      } else {              // 첫 시작이 흰색이라면
        if (i2 % 2 == 0) b1 = false;
      }

      int second = Integer.parseInt(st.nextToken());
      second--;

      if ((second / 8 + 1) % 2 != 0) {      // 첫 시작이 검정이라면
        if (second % 2 == 0) b2 = false;
      } else {                              // 첫 시작이 흰색이라면
        if (second % 2 != 0) b2 = false;
      }

      if (b1 == b2) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
