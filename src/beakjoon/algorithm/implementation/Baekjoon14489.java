package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14489 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int accountA = Integer.parseInt(st.nextToken());
    int accountB = Integer.parseInt(st.nextToken());

    int chicken = Integer.parseInt(br.readLine());
    chicken *= 2;

    int total = accountA + accountB;

    if (total >= chicken) System.out.println(total - chicken);
    else System.out.println(total);
  }
}
