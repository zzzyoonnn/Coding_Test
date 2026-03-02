package beakjoon.archive.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon5073 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    while (true) {
      int[] arr = Arrays.stream(br.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();

      if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

      Arrays.sort(arr);

      System.out.println(calculate(arr[0], arr[1], arr[2]));
    }

  }

  private static String calculate(int a, int b, int c) {
    if (a == b && a == c) return "Equilateral";

    if (c >= a + b) return "Invalid";

    if (a == b || a == c || b == c) return "Isosceles";

    return "Scalene";
  }
}
