package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 
  이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 
  각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다. 
  이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.
  숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
입력
- 다섯 개의 줄에 다섯 개의 정수로 숫자판이 주어진다.
출력
- 첫째 줄에 만들 수 있는 수들의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon2210 {
  static int n, m, k;
  static int[][] arr;
  static HashSet<String> set;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    arr = new int[5][5];        // 5 X 5 숫자판
    set = new HashSet<>();      // 서로 다른 6자리 수 담을 HashSet

    StringTokenizer st;
    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    String s = new String();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        dfs(i, j, 0, s);        // 한 칸씩 다 dfs해보기
      }
    }

    System.out.println(set.size());
  }

  private static void dfs(int i, int j, int count, String s) {
    if (count == 6) {       // 문자열이 6자리 수가 되었다면
      set.add(s);           // set에 추가
      return;
    }

    for (int k = 0; k < 4; k++) {   // 가능한 이동 방향(상, 하, 좌, 우) 확인
      int x = i + dx[k];
      int y = j + dy[k];
      if (x >= 0 && y >= 0 && x < 5 && y < 5) {
        dfs(x, y, count + 1, s + arr[x][y]);
      }
    }
  }
}
