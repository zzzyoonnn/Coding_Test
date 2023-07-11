package beakjoon.algorithm.mathematics;
/*
문제
- 밤고는 100원 동전을 N개 갖고 있고, 
  그 돈으로 가격이 M원인 초코바를 사 먹으려고 한다. 
  밤고는 갖고 있는 돈으로 초코바를 사 먹을 수 있는지 알고 싶어 한다.
  밤고가 가진 돈이 초코바의 가격 이상이면 밤고는 초코바를 살 수 있다. 
  밤고가 가진 돈이 초코바를 사기에 충분한지 판단해주자.
입력
- 첫 번째 줄에 두 정수 N과 M이 공백을 사이에 두고 주어진다. 
  (1 <= N <= 100, 1 <= M <= 10,000)
출력
- 밤고가 초코바를 살 수 있으면 Yes를, 없으면 No를 출력한다.
ex 1)
입력        출력
- 30 300    - Yes
ex 2)
입력        출력
- 5 10000   - No
ex 3)
입력        출력
- 7 785     - No
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon27959 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    n *= 100;

    if (n >= m) System.out.println("Yes");
    else System.out.println("No");
  }
}
