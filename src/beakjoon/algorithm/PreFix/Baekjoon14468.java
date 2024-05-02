package beakjoon.algorithm.PreFix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Baekjoon14468 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    ArrayList<String> list = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    int count = 0;
    for (int i = 1; i < s.length(); i++) {
      String slice = String.valueOf(s.charAt(i - 1)) + String.valueOf(s.charAt(i));

      if (set.contains(slice)) {
        count++;
        set.remove(slice);
      }
      else set.add(slice);

    }

    System.out.println(count);
  }
}
