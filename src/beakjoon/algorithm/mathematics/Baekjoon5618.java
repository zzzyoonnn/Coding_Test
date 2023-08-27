package beakjoon.algorithm.mathematics;
/*
문제
- 자연수 n개가 주어진다. 
  이 자연수의 공약수를 모두 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 n이 주어진다. 
  n은 2 또는 3이다. 
  둘째 줄에는 공약수를 구해야 하는 자연수 n개가 주어진다. 
  모든 자연수는 10^8 이하이다.
출력
- 입력으로 주어진 n개 수의 공약수를 한 줄에 하나씩 증가하는 순서대로 출력한다.
ex 1)
입력      출력
- 2       - 1
  75 125    5
            25
ex 2)
입력          출력
- 3           - 1
  110 22 88     2
                11
                22
ex 3)
입력          출력
- 3           - 1
  66 11 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon5618 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    for (int i = 1; i <= arr[0]; i++) {
      int count = 0;

      // 주어진 자연수의 공약수 찾기
      for (int j = 0; j < n; j++) {
        if (arr[j] % i == 0)
          count++;
      }

      // 자연수 n개가 모두 i로 나누어 떨어질 때
      if (count == n) System.out.println(i);
    }
  }
}
