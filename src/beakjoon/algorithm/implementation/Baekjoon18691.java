package beakjoon.algorithm.implementation;
/*
문제
- Pokemon Go just released the Buddy update. 
  It lets you select a Pokemon to appear alongside your trainer’s avatar on your profile screen. 
  As you walk with your buddy, it will find candy that can be used to evolve the Pokemon.
  The Buddy system divides the Pokemons into 3 groups. 
  Each group gives one candy upon walking for 1, 3, and 5 kilometers respectively
  In this problem you will be given the Pokemon group G, the number of candies C you initially have, 
  and the number of candies E required to evolve the Pokemon. 
  You should calculate the number of Kilometers required to walk in order to evolve the Pokemon.
입력
- Your program will be tested on one or more test cases. 
  The first line of the input will be a single integer T, the number of test cases (1 ≤ T ≤ 100).
  Each test case consists of a line containing three space separated integers:
    G: The group of the Pokemon (1 ≤ G ≤ 3)
    C: The initial candies you have (0 ≤ C ≤ 100)
    E: The candies required to evolve the Pokemon (1 ≤ E ≤ 100)
출력
- For each test case, print a single line containing the number of Kilometers of walking required to Evolve the Pokemon.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18691 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int g = Integer.parseInt(st.nextToken());
      if (g == 1) g = 1;
      else if (g == 2) g = 3;
      else if (g == 3) g = 5;
      int c = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      if (e - c < 0) System.out.println(0);
      else System.out.println((e - c) * g);
    }
  }
}
