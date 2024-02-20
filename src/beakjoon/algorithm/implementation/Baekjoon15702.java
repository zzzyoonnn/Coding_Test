package beakjoon.algorithm.implementation;
/*
문제
- 이번 중간고사에는 총 N문제가 나왔고, 응시한 사람의 수는 M명이다. 
  각 문제의 배점과 각 사람의 결과가 주어졌을 때, 가장 높은 점수를 획득한 사람을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 문제의 개수 N과 응시자의 수 M이 주어진다. (1 ≤ N ≤ 100, 1 ≤ M ≤ 100)
  둘째 줄에는 문제의 배점이 1번 문제부터 N번 문제까지 순서대로 주어진다. 
  각 문제의 배점은 100보다 작거나 같은 자연수이며, 공백으로 구분되어져 있다.
  셋째 줄부터 M개의 줄에는 응시자의 정보가 한 줄에 하나씩 주어진다. 
  응시자의 정보는 총 N+1개의 문자열로 이루어져 있다. 
  첫 번째 문자열은 응시자의 수험 번호이다. 
  수험 번호는 100,000보다 작거나 같은 자연수이다. 
  두 번째 부터 N+1번째 문자열은 각 시험 문제의 채점 결과이다. 
  채점 결과는 1번 문제부터 N번 문제까지 순서대로 주어지며, 'O' 또는 'X'이다. 
  'O'가 주어진 경우에는 해당 문제를 맞춘 것이고, 'X'가 주어진 경우에는 해당 문제를 틀린 것이다.
  문제를 맞춘 경우에는 그 문제의 배점이 점수에 더해지게 되며, 틀린 경우에는 더해지지 않는다. 
  수험 번호가 중복되는 경우는 없다.
출력
- 첫째 줄에 가장 높은 점수를 얻은 학생의 번호와 점수를 공백으로 구분해 출력한다. 
  만약, 가장 높은 점수를 얻은 학생이 여러 명이라면, 수험 번호가 가장 작은 것을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon15702 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());   // 문제의 개수
    int m = Integer.parseInt(st.nextToken());   // 응시자 수

    int[] score = new int[n + 1];   // 점수
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      score[i] = Integer.parseInt(st.nextToken());
    }

    int total = 0;
    String s = "";
    int max = Integer.MIN_VALUE;
    int student = Integer.MAX_VALUE;
    int temp_student = 0;

    for (int i = 0; i < m; i++) {
      total = 0;

      st = new StringTokenizer(br.readLine());
      temp_student = Integer.parseInt(st.nextToken());
      for (int j = 0; j < n; j++) {
        s = st.nextToken();
        if (s.equals("O")) total += score[j];
      }

      if (max <= total) {
        if (max == total && temp_student > student) {
          continue;
        } else {
          student = temp_student;
        }
        max = total;
      }
    }
    System.out.println(student + " " + max);
  }
}
