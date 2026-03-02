package beakjoon.archive.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10101 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());

    System.out.print(calculate(a, b, c));
  }

  private static String calculate(int a, int b, int c) {

    if (a + b + c != 180) return "Error";

    if (a == b && a == c) return "Equilateral";

    if (a != b && a != c && b != c) return "Scalene";

    return "Isosceles";
  }
}
