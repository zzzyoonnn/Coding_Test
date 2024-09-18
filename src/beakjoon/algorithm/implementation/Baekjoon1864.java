package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon1864 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    map.put('-', 0);
    map.put('\\',1);
    map.put('(', 2);
    map.put('@', 3);
    map.put('?', 4);
    map.put('>', 5);
    map.put('&', 6);
    map.put('%', 7);
    map.put('/', -1);

    String s;
    while (!(s = br.readLine()).equals("#")) {
      int length = s.length() - 1;
      int result = 0;

      for (int i = 0; i < s.length(); i++) {
        int n = 1;
        for (int j = length - i; j > 0; j--) {
          n *= 8;
        }

        result += map.get(s.charAt(i)) * n;
      }

      System.out.println(result);
    }
  }
}
