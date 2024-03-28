package beakjoon.algorithm.implementation;
/*
문제
- 도현이네 반 N명의 친구 관계가 입력으로 주어진다. 
  이때, 각 사람의 친구의 수를 출력하는 프로그램을 작성하시오.
  각 사람은 1번부터 N번까지 번호가 매겨져 있다. 
  A와 B가 친구면, B와 A도 친구이다. 
  자기 자신과 친구인 경우, 즉 A와 B가 같은 경우는 없다.
입력
- 첫째 줄에 도현이네 반 학생의 수 N(1 ≤ N ≤ 100,000), M(0 ≤ M ≤ 1,000,000)이 주어진다. 
  둘째 줄부터 M개의 줄에는 친구 관계를 나타내는 A B가 한 줄에 하나씩 주어진다.
  A B가 입력으로 주어진 경우에 B A가 다시 입력으로 주어지는 경우는 없다.
출력
- 첫째 줄부터 N번째 줄에 걸쳐서 각 학생의 친구의 수를 1번 학생부터 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10865 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());    // 반 학생수
    int m = Integer.parseInt(st.nextToken());    // 친구 관계의 개수

    int[] friends = new int[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      friends[a]++;
      friends[b]++;
    }

    for (int i = 1; i <= n; i++) {
      System.out.println(friends[i]);
    }
  }
}
