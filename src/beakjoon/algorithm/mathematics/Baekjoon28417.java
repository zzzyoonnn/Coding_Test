package beakjoon.algorithm.mathematics;
/*
문제
- 2020년부터 올림픽 정식 종목으로 포함된 스케이트보드는 스트리트와 파크 종목으로 나뉜다. 
  그 중 스트리트는 계단, 난간, 레일, 경사면 등 다양한 구조물을 활용해 기술을 구사하는 종목이다. 
  스트리트 종목의 채점 방식은 다음과 같다.
    각 선수는 두 차례의 런, 다섯 차례의 트릭 연기를 수행해 각각 0부터 100 사이의 점수를 받는다.
    두 차례의 런에서 받은 최고 점수와 다섯 차례의 트릭 연기를 통해 받은 점수 중 상위 2개의 점수, 총 3개의 점수를 더한 값이 최종 점수가 된다.
    최종 점수가 가장 높은 사람을 우승자로 정한다. 단, 최고 득점자가 여러 명이면 공동 우승으로 한다.
  출전한 선수들의 점수표가 주어졌을 때, 우승자의 최종 점수를 구해 보자.
입력
- 첫째 줄에 사람의 수 N이 주어진다. (1 <= N <= 100\,000) 
  둘째 줄부터 N 개의 줄에 걸쳐 2개의 런, 5개의 트릭 점수를 나타내는 정수 7개가 공백으로 구분되어 순서대로 주어진다. (0 <=  점수 <= 100) 
출력
- 첫째 줄에 우승자의 최종 점수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon28417 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] score = new int[n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      int run = (n1 > n2) ? n1 : n2;

      int[] trick = new int[5];
      for (int j = 0; j < trick.length; j++) {
        trick[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(trick);

      score[i] = run + trick[trick.length - 1] + trick[trick.length - 2];
    }

    Arrays.sort(score);
    System.out.println(score[score.length - 1]);
  }
}
