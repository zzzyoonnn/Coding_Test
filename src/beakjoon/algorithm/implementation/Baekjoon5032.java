package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5032 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int e = Integer.parseInt(st.nextToken());
    int f = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int answer = 0;

    int owned = e + f;

    while (true) {
      int temp = owned % c;     // 교환 못하는 병의 개수

      answer += owned / c;      // 병 교환하기
      owned /= c;

      owned += temp;            // 교환하고 남은 병의 개수

      if (owned < c) break;     // 더 이상 교환을 못한다면 종료
    }

    System.out.println(answer);
  }
}
