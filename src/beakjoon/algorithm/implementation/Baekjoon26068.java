package beakjoon.algorithm.implementation;
/*
문제
- 마음씨 착한 곰곰이는 임스에게 치킨 기프티콘을 여러 번 선물했다.
  기프티콘이 있다는 사실을 잊고 있던 임스는 치킨 댄스를 추는 곰곰이를 보고 그 사실이 생각났다.
  치킨 기프티콘을 선물받은 횟수 N과 선물의 남은 유효기간이 주어질 때, 임스가 사용할 기프티콘의 개수를 구하시오.
  임스는 기프티콘을 아껴 사용하기 위해 유효기간이 90일 이하로 남은 기프티콘만 사용할 것이다.
입력
- 첫 번째 줄에는 임스가 받은 기프티콘의 개수 정수 N이 주어진다. (1 <= N <= 1,000$)
  두 번째 줄부터 N개의 줄에 걸쳐 
  i번째 기프티콘의 남은 유효기간 xi가 D-xi 와 같은 형식으로 주어진다. (1 <= xi <= 365)
출력
- 임스가 사용할 기프티콘의 개수를 출력하시오.
ex 1)
입력		출력
- 3         - 3
  D-86
  D-8
  D-6
ex 2)
입력        출력
- 4         - 2
  D-98
  D-5
  D-94
  D-2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon26068 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), "-");
      String s = st.nextToken();
      int day = Integer.parseInt(st.nextToken());
      if (day <= 90) count++;
    }

    System.out.println(count);
  }
}
