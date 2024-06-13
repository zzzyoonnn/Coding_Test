package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon31775 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    boolean check = true;

    HashSet<Character> set = new HashSet<>();
    set.add('l');
    set.add('k');
    set.add('p');

    for (int i = 0; i < 3; i++) {
      s = br.readLine();
      char c = s.charAt(0);
      if (set.contains(c)) {
        set.remove(c);
      } else {
        check = false;
      }
    }

    if (check) System.out.println("GLOBAL");
    else System.out.println("PONIX");
  }
}
