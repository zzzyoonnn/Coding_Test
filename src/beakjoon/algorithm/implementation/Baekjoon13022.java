package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon13022 {
  static int[] count;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    if (s.length() < 4) {
      System.out.println(0);
      System.exit(0);
    }

    HashMap<Character, Integer> map = new HashMap<>();
    map.put('w', 0);
    map.put('o', 1);
    map.put('l', 2);
    map.put('f', 3);

    count = new int[4];

    boolean check = true;       // wolf 문자열 생성 가능

    count[map.get(s.charAt(0))]++;
    for (int i = 1; i < s.length(); i++) {
      int pre = map.get(s.charAt(i - 1));       // 이전 값
      int cur = map.get(s.charAt(i));           // 현재
      int dif = cur - pre;

      if (dif == -3) {
        if (check()) {
          count = new int[4];
          count[0]++;
        } else {
          check = false;
          break;
        }
      } else if (dif == 1 || dif == 0) {
        count[cur]++;
      } else {
        check = false;
        break;
      }
    }
    if (!check()) check = false;

    if (check) System.out.println(1);
    else System.out.println(0);
  }

  private static boolean check() {
    if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) {
      return true;
    } else {
      return false;
    }
  }
}