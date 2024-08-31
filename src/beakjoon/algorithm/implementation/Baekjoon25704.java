package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon25704 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());

    double discount = 0;
    int coupon = 0;
    int price = 0;
    if (n >= 20) price = p - (int)(p * 0.25);
    else if (n >= 15) price = p - 2000;
    else if (n >= 10) price = p - (int)(p * 0.1);
    else if (n >= 5) price = p - 500;


    System.out.println(price);
  }
}
