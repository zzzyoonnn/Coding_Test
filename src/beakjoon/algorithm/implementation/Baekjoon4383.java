package beakjoon.algorithm.implementation;
/*
문제
- Jolly jumper라 불리는 수열이 있다. 
  길이가 1인 수열은 무조건 Jolly jumper이고, 
  길이가 2이상일 때는 n개의 연속된 두 수의 차의 절댓값이 1부터 n-1까지 모두 나와야 Jolly jumper라고 한다. 
  예를 들어
  1 4 2 3
  이것은 Jolly jumper인데, 두 수의 차의 절댓값이 각각 3,2,1이기 때문이다. 
  하여튼 조건을 충족하면 어느 수열이든 Jolly jumper라 할 수 있다. 
  이제 각 케이스마다 Jolly jumper인지를 판별하자.
입력
- 각 줄의 첫 수로 n이 주어진다.(n < 3000) 그 다음에는 n개의 수가 주어진다.
출력
- 각 줄마다 Jolly 인지 Not jolly 인지 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4383 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String s;

    while ((s = br.readLine()) != null) {
      st = new StringTokenizer(s);

      int n = Integer.parseInt(st.nextToken());

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      boolean[] check = new boolean[n];     // Jolly jump 확인용
      for (int i = 1; i < arr.length; i++) {
        int num = Math.abs(arr[i] - arr[i - 1]);    // 연속된 두 수의 차를 양수로 구하기
        if (num >= n) break;    // check의 크기가 n - 1이기 때문
        check[num] = true;
      }

      boolean jolly = true;
      for (int i = 1; i < check.length; i++) {
        if (!check[i]) {    //  연속된 두 수의 차가 1 ~ n - 1인지 확인
          jolly = false;
          break;
        }
      }

      if (jolly) System.out.println("Jolly");
      else System.out.println("Not jolly");
    }
  }
}