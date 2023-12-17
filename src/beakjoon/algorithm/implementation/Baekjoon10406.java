package beakjoon.algorithm.implementation;
/*
문제
- Box is a really violent sport. 
  To compensate, there is a code of conduct to maintain chivalry and fellowship atop the ring in friendly matches. 
  One of the most well known rules of this code of conduct is to avoid hitting the opponent below the waist or above the neck.
  Given the heights of the waist and neck of an opponent, 
  and the heights of a set of punches, 
  calculate how many of those punches are fair according to the rule above.
입력
- The first line contains three integers W, N and P, 
  representing respectively the height of the waist of the opponent, 
  the height of his neck, and the number of thrown punches (1 ≤ W < N ≤ 200 and 1 ≤ P ≤ 100). 
  The second line contains P integers H1, H2, . . . , HP (1 ≤ Hi ≤ 200 for i = 1, 2, . . . , P) 
  indicating the heights of the punches. 
  All heights are given in centimeters.
출력
- Output a line with an integer representing the number of punches that are fair, according to the code of conduct.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10406 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int w = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());

    int[] arr = new int[p];
    int count = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i] >= w && arr[i] <= n) count++;
    }
    System.out.println(count);
  }
}
