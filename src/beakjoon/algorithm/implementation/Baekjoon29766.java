package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon29766 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int count = 0;
    String str = s.replaceAll("DKSH", "");

    System.out.println(str);

    System.out.println((s.length() - str.length()) / 4);
  }
}
