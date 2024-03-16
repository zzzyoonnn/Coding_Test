package beakjoon.algorithm.implementation;
/*
문제
- 예선 문제를 성실하게 복습한 학생들이라면 예선에 출제된 5문제가 난이도 순서대로 정렬되어 있다는 것을 알아차렸을 것이다.
  하지만 본선은 문제 제목에 대해 사전순으로 정렬했기 때문에 난이도 순서대로 정렬되어 있지 않을 수 있다.
  문제 제목과 문제의 난이도가 주어지면 가장 쉬운 문제의 제목을 출력하는 프로그램을 작성하자.
  문제의 난이도는 자연수로 표현되며, 수가 클수록 어려운 문제다.
입력
- 첫째 줄에 문제의 개수 N이 주어진다.
  둘째 줄부터 N개의 줄에 문제 제목과 문제 난이도가 공백으로 구분되어 주어진다.
출력
- 가장 쉬운 문제의 제목을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon22966 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 문제의 개수
    StringTokenizer st;

    String title = "";
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String s = st.nextToken();
      int level = Integer.parseInt(st.nextToken());

      if (min > level) {
        min = level;
        title = s;
      }
    }

    System.out.println(title);
  }
}
