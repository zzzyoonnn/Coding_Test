package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon30642 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String name = br.readLine();
    int k = Integer.parseInt(br.readLine());

    if (name.equals("annyong")) {
      if (k % 2 == 1) System.out.println(k);
      else System.out.println(k < n ? k + 1 : k - 1);
    } else {
      if (k % 2 == 0) System.out.println(k);
      else System.out.println(k < n ? k + 1 : k - 1);
    }
  }
} 
