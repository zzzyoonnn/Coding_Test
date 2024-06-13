package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon4659 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    StringBuilder sb = new StringBuilder();

    HashSet<Character> vowels = new HashSet<>();   // 자음

    vowels.add('a');
    vowels.add('e');
    vowels.add('i');
    vowels.add('o');
    vowels.add('u');


    while (true) {
      s = br.readLine();

      if (s.equals("end")) break;

      sb.append("<").append(s).append("> ");

      int cntV = 0;             // 연속된 모음의 개수
      int cntC = 0;             // 연속된 자음의 개수
      boolean checkV = false;
      boolean check = true;     // 높은 품질의 조건을 만족하는지 확인용

      if (vowels.contains(s.charAt(0))) checkV = true;

      for (int i = 1; i < s.length(); i++) {
        char pre = s.charAt(i - 1);
        char now = s.charAt(i);

        System.out.println(s);
        System.out.println(s.charAt(i - 1) + " " + s.charAt(i));

        // 모음일 경우
        if (vowels.contains(now)) {
          checkV = true;

          cntC = 0;
          cntV++;

          if (cntV >= 2) {
            check = false;
          }

          if (now == pre) {
            if (now == 'e' || now == 'o') continue;
            else check = false;
          }
        } else {
          cntV = 0;
          cntC++;

          if (cntC >= 2) {
            check = false;
          }

          if (now == pre) {
            check = false;
          }

        }
      }

      if (check && checkV) sb.append("is acceptable.").append('\n');
      else sb.append("is not acceptable.").append('\n');
    }

    System.out.println(sb);
  }
}
