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
      boolean color1 = true;        // true : white, false : black
      boolean color2 = true;        // true : white, false : black

      String first = st.nextToken();
      int i1 = first.charAt(0) - 'A' + 1;
      int i2 = first.charAt(1) - '0';

      if (i1 % 2 == 1) {        // 검정부터 시작
        if (i2 % 2 == 1) color1 = false;
        else color1 = true;
      } else {                  // 흰색부터 시작
        if (i2 % 2 == 0) color1 = false;
        else color1 = true;
      }

      int second = Integer.parseInt(st.nextToken());

      if (second % 8 == 0) {
        if ((second / 8) % 2 == 1) color2 = true;
        else color2 = false;
      } else if ((second / 8) % 2 == 0) {
        if (second % 2 == 1) color2 = false;
        else color2 = true;
      } else {
        if (second % 2 == 0) color2 = false;
        else color2 = true;
      }


      if (color1 == color2) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
