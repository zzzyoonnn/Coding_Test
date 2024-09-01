package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon25704 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());

    int price = p;
    if (n >= 20) price = Math.min(price, p - (p / 4));
    if (n >= 15) price = Math.min(price, p - 2000);
    if (n >= 10) price = Math.min(price, p - (p / 10));
    if (n >= 5) price = Math.min(price, p - 500);

    if (price < 0) price = 0;

    System.out.println(price);
  }
}
