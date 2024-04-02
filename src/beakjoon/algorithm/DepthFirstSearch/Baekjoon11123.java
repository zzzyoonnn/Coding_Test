package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 얼마전에 나는 불면증에 시달렸지... 천장이 뚫어져라 뜬 눈으로 밤을 지새우곤 했었지.  
  그러던 어느 날 내 친구 광민이에게 나의 불면증에 대해 말했더니 이렇게 말하더군. 
  "양이라도 세봐!"  정말 도움이 안되는 친구라고 생각했었지. 
  그런데 막상 또 다시 잠을 청해보려고 침대에 눕고 보니 양을 세고 있더군... 
  그런데 양을 세다보니 이걸로 프로그램을 하나 짜볼 수 있겠단 생각이 들더군 후후후... 
  그렇게 나는 침대에서 일어나 컴퓨터 앞으로 향했지.
  양을 # 으로 나타내고 . 으로 풀을 표현하는 거야. 
  서로 다른 # 두 개 이상이 붙어있다면 한 무리의 양들이 있는거지. 
  그래... 좋았어..! 이걸로 초원에서 풀을 뜯고 있는 양들을 그리드로 표현해 보는거야!
  그렇게 나는 양들을 그리드로 표현하고 나니까 갑자기 졸렵기 시작했어. 
  하지만 난 너무 궁금했지. 
  내가 표현한 그 그리드 위에 몇 개의 양무리가 있었는지! 
  그래서 나는 동이 트기 전까지 이 프로그램을 작성하고 장렬히 전사했지. 
  다음날 내가 잠에서 깨어났을 때 내 모니터에는 몇 개의 양무리가 있었는지 출력되어 있었지.
입력
- 첫 번째 줄은 테스트 케이스의 수를 나타나는 T를 입력받는다.
  이후 각 테스트 케이스의 첫 번째 줄에서는 H,W 를 입력받는다. 
  H는 그리드의 높이이고, W는 그리드의 너비이다. 
  이후 그리드의 높이 H 에 걸쳐서 W개의 문자로 이루어진 문자열 하나를 입력받는다. 
    0 < T ≤ 100
    0 < H, W ≤ 100
출력
- 각 테스트 케이스마다, 양의 몇 개의 무리로 이루어져 있었는지를 한 줄에 출력하면 된다. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11123 {
  static int h, w;
  static char[][] grid;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());        // 테스트 케이스 개수
    String s;
    StringTokenizer st;
    for (int tc = 0; tc < t; tc++) {
      st = new StringTokenizer(br.readLine());
      h = Integer.parseInt(st.nextToken());         // 그리드의 높이
      w = Integer.parseInt(st.nextToken());         // 그리드의 너비

      grid = new char[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        s = br.readLine();
        for (int j = 0; j < w; j++) {
          grid[i][j] = s.charAt(j);
        }
      }

      int count = 0;        // 양 무리의 개수
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (grid[i][j] == '#' && !visited[i][j]) {    // 현재 위치가 '양'이고 방문되지 않았다면 dfs 실행(양 무리 발견 및 탐색)
            dfs(i, j);
            count++;    // 양 무리 발견으로 인한 +1
          }
        }
      }

      System.out.println(count);
    }
  }

  private static void dfs(int i, int j) {
    visited[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];

      if (x >= 0 && y >= 0 && x < h && y < w) {
        if (grid[x][y] == '#' && !visited[x][y]) {      // 양이 있고 방문되지 않았다면 dfs 실행(양 무리 발견 및 탐색)
          dfs(x, y);
        }
      }
    }
  }
}