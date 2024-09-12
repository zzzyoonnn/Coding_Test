package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon26070 {
  static long count;
  static int a, b, c;
  static int x, y, z;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());   // chicken
    b = Integer.parseInt(st.nextToken());   // pizza
    c = Integer.parseInt(st.nextToken());   // hamburger

    st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());   // chicken's ticket
    y = Integer.parseInt(st.nextToken());   // pizza's ticket
    z = Integer.parseInt(st.nextToken());   // hamburger's ticket

    count = 0;

    calculateMax();

    y += (x / 3);
    x %= 3;

    calculateMax();

    z += (y / 3);
    y %= 3;

    calculateMax();

    x += (z / 3);
    z %= 3;

    calculateMax();

    y += (x / 3);
    x %= 3;

    calculateMax();

    System.out.println(count);
  }

  private static void calculateMax() {
    // Process chicken
    int chicken = Math.min(a, x);
    count += chicken;
    a -= chicken;
    x -= chicken;

    // Process pizza
    int pizza = Math.min(b, y);
    count += pizza;
    b -= pizza;
    y -= pizza;

    // Process hamburger
    int hamburger = Math.min(c, z);
    count += hamburger;
    c -= hamburger;
    z -= hamburger;
  }
}