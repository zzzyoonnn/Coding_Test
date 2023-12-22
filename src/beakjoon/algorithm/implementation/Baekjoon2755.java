package beakjoon.algorithm.implementation;
/*
문제
- 최백준이 이번 학기에 들은 과목과 학점 그리고 성적이 주어졌을 때, 평균 평점을 계산하는 프로그램을 작성하시오.
  성적은 A+~F까지 총 13개가 있다.
    A+: 4.3, A0: 4.0, A-: 3.7
    B+: 3.3, B0: 3.0, B-: 2.7
    C+: 2.3, C0: 2.0, C-: 1.7
    D+: 1.3, D0: 1.0, D-: 0.7
    F: 0.0
  평균 평점은 각 과목의 학점*성적을 모두 더한 뒤에, 총 학점으로 나누면 된다.
입력
- 첫째 줄에, 백준이가 이번 학기에 들은 과목 수가 주어진다. 
  둘째 줄부터 N개의 줄에 각 과목의 과목명, 학점, 성적이 주어진다. 
  과목명은 알파벳 소문자와 숫자, 그리고 밑줄 (_)로만 이루어져 있으며, 
  최대 100글자이고, 학점은 1보다 크거나 같고, 3보다 작거나 같은 자연수이다. 
  성적은 문제에 설명한 13가지 중 하나이다. 
출력
- 첫째 줄에 평균 평점을 소수점 셋째 자리에서 반올림해서 둘째 자리까지 출력한다. (평균 평점이 1.5이면 1.50을 출력한다.)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2755 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int total_credit = 0;
    String grade;
    StringTokenizer st;
    double total = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int credit = 0;
      double score = 0;
      credit = Integer.parseInt(st.nextToken());
      total_credit += credit;
      grade = st.nextToken();
      if (grade.equals("A+")) score += 4.3;
      else if (grade.equals("A0")) score += 4.0;
      else if (grade.equals("A-")) score += 3.7;
      else if (grade.equals("B+")) score += 3.3;
      else if (grade.equals("B0")) score += 3.0;
      else if (grade.equals("B-")) score += 2.7;
      else if (grade.equals("C+")) score += 2.3;
      else if (grade.equals("C0")) score += 2.0;
      else if (grade.equals("C-")) score += 1.7;
      else if (grade.equals("D+")) score += 1.3;
      else if (grade.equals("D0")) score += 1.0;
      else if (grade.equals("D-")) score += 0.7;
      else score = 0.0;

      total += (credit * score);
    }

    String result = String.format("%.2f", total / total_credit);
    System.out.print(result);

  }
}
