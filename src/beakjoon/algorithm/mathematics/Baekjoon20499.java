package beakjoon.algorithm.mathematics;
/*
문제
- 아무래도 우리 팀 다리우스가 고수인 것 같다. 
  그의 K/D/A를 보고 그가 「진짜」인지 판별해 보자.
  K+A < D이거나, D = 0이면 그는 「가짜」이고, 그렇지 않으면 「진짜」이다.
입력
- K/D/A가 주어진다.
출력
- 그가 「진짜」이면 gosu, 「가짜」이면 hasu를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon20499 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "/");
    int k = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());

    if (k + a < d || d == 0) System.out.println("hasu");
    else System.out.println("gosu");
  }
}
