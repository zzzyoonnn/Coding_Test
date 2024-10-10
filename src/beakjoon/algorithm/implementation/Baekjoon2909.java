package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2909 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    double n = Math.pow(10, Integer.parseInt(st.nextToken()));

    int intValue = (int)Math.floor(Math.round(num / n) * n);

    System.out.print(intValue);
  }
}
