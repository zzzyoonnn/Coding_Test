package beakjoon.algorithm.implementation;
import java.util.Scanner;

public class Baekjoon28431_1 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[10];

    for (int i = 0; i < 5; i++) {
      int n = sc.nextInt();
      arr[n]++;
    }

    for (int i = 0; i < 10; i++) {
      if (arr[i] % 2 != 0) System.out.println(i);
    }
  }
}