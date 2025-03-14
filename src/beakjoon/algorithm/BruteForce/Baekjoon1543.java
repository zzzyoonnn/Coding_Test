package beakjoon.algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1543 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String original = br.readLine();
    String find = br.readLine();

    int count = 0;
    while (true) {
      if (original.contains(find)) {
        count++;

        original = original.replaceFirst(find, "_");
      } else {
        break;
      }
    }

    System.out.print(count);
  }
}
