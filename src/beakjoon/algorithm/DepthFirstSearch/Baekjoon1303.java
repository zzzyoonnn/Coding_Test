package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 전쟁은 어느덧 전면전이 시작되었다. 
  결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다. 
  그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다. 
  문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
  N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 
  과연 지금 난전의 상황에서는 누가 승리할 것인가? 
  단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
입력
- 첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 
  그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다. 
  모든 자리에는 병사가 한 명 있다. 
  B는 파란색, W는 흰색이다. 
  당신의 병사와 적국의 병사는 한 명 이상 존재한다.
출력
- 첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1303 {
  static int n, m, count;
  static boolean[][] soldier;
  static boolean[][] checked;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    soldier = new boolean[m][n];       // 병사 위치
    checked = new boolean[m][n];    // 확인용

    String s;
    for (int i = 0; i < m; i++) {
      s = br.readLine();
      for (int j = 0; j < n; j++) {
        if(s.charAt(j) == 'W') {
          soldier[i][j] = true;
        }
      }
    }

    int w = 0;
    int b = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (checked[i][j]) continue;
        count = 0;
        System.out.println(count);
        if (soldier[i][j]) {
          dfs(i, j, true);
          w += (count * count);
        } else {
          dfs(i, j, false);
          System.out.println(count);
          b += (count * count);
        }
      }
    }

    System.out.println(w + " " + b);
  }

  private static void dfs(int i, int j, boolean check) {
    checked[i][j] = true;
    count++;

    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < m && y < n && !checked[x][y]) {
        if (soldier[x][y] == check) dfs(x, y, true);
        else dfs(x, y, false);
      }
    }
  }
}
