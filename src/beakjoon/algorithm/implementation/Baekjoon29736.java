package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon29736 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int answer = 0;
    int solveStart = k - x;
    if (solveStart < 0) {
      solveStart = 0;
    }
    int solveEnd = k + x;

    if (solveEnd < a || solveStart > b){
      System.out.print("IMPOSSIBLE");
      System.exit(0);
    }

    if (solveStart >= a && solveEnd <= b) answer = solveEnd - solveStart + 1;
    else if (solveStart < a && solveEnd <= b) answer = solveEnd - a + 1;
    else if (solveStart >= a && solveEnd > b) answer = b - solveStart + 1;
    else if (solveStart < a && solveEnd > b) answer = b - a + 1;

    System.out.print(answer);
  }
}
