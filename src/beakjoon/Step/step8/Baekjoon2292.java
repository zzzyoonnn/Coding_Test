package beakjoon.Step.step8;
/*
문제
- 위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
  그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 
  이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
  숫자 N이 주어졌을 때, 
  벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 
  몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 
  예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
입력
- 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
출력
- 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
ex 1)
입력			출력
- 13			- 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2292 {
  // BufferedReader를 사용할 경우 예외처리 즉, throws IOException을 해야 함
  public static void main(String[] args) throws IOException {
    // BufferedReader를 이용하여 값 입력받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int count = 1;	// 지나간 방 수
    int range = 2;	// 범위

    if (n == 1) {
      System.out.println(1);
    } else {
      while (range <= n) {	// 범위가 n보다 커지기 직전까지 반복
        range = range + (6 * count);	// 다음 범위의 최솟값으로 초기화
        count++;	// count 1 증가
      }
      System.out.println(count);
    }
  }
}
