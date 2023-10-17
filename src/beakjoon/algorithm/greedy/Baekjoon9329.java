package beakjoon.algorithm.greedy;
/*
문제
- ACM-ICPC 아시아 지역 대회기간 중 
  대전의 패스트 푸드 음식점들은 그들의 음식점을 홍보하기 위해 이벤트를 준비한다. 
  특정 음식을 먹을 때 마다 스티커를 하나 제공하는데 스티커를 모으면 상금으로 교환할 수 있다. 
  같은 종류의 스티커가 필요한 상금은 여러 번 교환할 수 있으며, 
  같은 종류의 스티커를 가진 서로 다른 액수의 상금은 존재하지 않는다. 
  상금 교환에 필요없는 스티커도 있다.
  지역대회를 보러 가면서, 
  당신의 코치가 패스트 푸드 음식점에서만 식사를 하도록 허락했을 때, 
  얼마나 많은 상금을 획득할 수 있을까?
입력
- 입력은 여러개의 테스트 케이스로 이루어져있다. 
  각 테스트 케이스마다 첫째 줄에는 서로 다른 상금의 종류 n (1 ≤ n ≤ 10) 과 
  코치가 가지고 있는 스티커의 종류 (1 ≤ m ≤ 30, 종류는 1부터 m까지 번호가 매겨진다) 가 주어진다. 
  다음 n개의 줄은 상금에 관한 정보가 주어지는데 
  각 줄마다 첫 번째 정수는 해당 상금에 필요한 스티커의 개수 k (1 ≤ k ≤ m) 가 주어지며 
  뒤이어 k개의 정수에는 해당 상금에 필요한 스티커의 종류가 주어지며 
  마지막으로 상금의 액수가 주어진다 (최대 1,000,000). 
  n개의 모든 입력이 주어진 후 마지막 줄은 코치가 가지고 있는 1부터 m까지 스티커의 개수가 각각 주어진다. 
  각각의 스티커의 개수는 100개 이하이다.
출력
- 각각의 케이스마다 최대 상금의 액수를 한줄씩 출력한다.
ex 1)
입력          출력
- 3             - 500
  2 10            2500
  3 1 2 3 100     1900
  4 4 5 6 7 200
  2 3 1 4 5 2 2 1 3 4
  3 6
  2 1 2 100
  3 3 4 5 200
  1 6 300
  1 2 3 4 5 6
  3 6
  2 1 2 100
  3 3 4 5 200
  1 6 300
  1 2 0 4 5 6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9329 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int prize = Integer.parseInt(st.nextToken());
      int sticker = Integer.parseInt(st.nextToken());
      int[][] prizes = new int[prize][100];
      int[] stickers = new int[sticker + 1];

      for (int j = 0; j < prize; j++) {
        st = new StringTokenizer(br.readLine());
        prizes[j][0] = Integer.parseInt(st.nextToken());
        for (int k = 1; k <= prizes[j][0] + 1; k++) {
          prizes[j][k] = Integer.parseInt(st.nextToken());
        }
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < sticker; j++) {
        stickers[j] = Integer.parseInt(st.nextToken());
      }

      int result = 0;
      for (int j = 0; j < prize; j++) {
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= prizes[j][0]; k++) {
          if (stickers[prizes[j][k] - 1] < min) {
            min = stickers[prizes[j][k] - 1];
          }
        }
        result += prizes[j][prizes[j][0] + 1] * min;
      }
      System.out.println(result);
    }
  }
}
