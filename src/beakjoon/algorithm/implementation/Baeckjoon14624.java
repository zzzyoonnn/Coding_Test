package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baeckjoon14624 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    if (n % 2 == 0) {
      System.out.println("I LOVE CBNU");
      System.exit(0);
    }


  }
}
