package beakjoon.algorithm.mathematics;
/*
문제
- "나는 요리사다"는 다섯 참가자들이 서로의 요리 실력을 뽐내는 티비 프로이다. 
  각 참가자는 자신있는 음식을 하나씩 만들어오고, 서로 다른 사람의 음식을 점수로 평가해준다. 
  점수는 1점부터 5점까지 있다.
  각 참가자가 얻은 점수는 다른 사람이 평가해 준 점수의 합이다. 
  이 쇼의 우승자는 가장 많은 점수를 얻은 사람이 된다.
  각 참가자가 얻은 평가 점수가 주어졌을 때, 우승자와 그의 점수를 구하는 프로그램을 작성하시오.
입력
- 총 다섯 개 줄에 각 참가자가 얻은 네 개의 평가 점수가 공백으로 구분되어 주어진다. 
  첫 번째 참가자부터 다섯 번째 참가자까지 순서대로 주어진다. 
  항상 우승자가 유일한 경우만 입력으로 주어진다.
출력
- 첫째 줄에 우승자의 번호와 그가 얻은 점수를 출력한다.
ex 1)
입력        출력
- 5 4 4 5   - 4 19
  5 4 4 4
  5 5 4 4
  5 5 5 4
  4 4 4 5
ex 2)
입력        출력
- 4 4 3 3   - 2 17
  5 4 3 5
  5 5 2 4
  5 5 5 1
  4 4 4 4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2953 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int score[] = new int[4];
    int total[] = new int[5];
    int max = 0;
    int winner = 0;

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int sum = 0;
      for (int j = 0; j < 4; j++) {
        score[j] = Integer.parseInt(st.nextToken());
        sum += score[j];
      }
      total[i] = sum;
    }

    for (int i = 0; i < 5; i++) {
      if (total[i] > max) {
        max = total[i];
        winner = i + 1;
      }
    }
    System.out.println(winner + " " + max);
  }
}
