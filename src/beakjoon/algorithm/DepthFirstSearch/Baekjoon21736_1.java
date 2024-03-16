package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 2020년에 입학한 헌내기 도연이가 있다. 
  도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다. 
  드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다. 
  도연이가 다니는 대학의 캠퍼스는 N X M 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다. 
  예를 들어, 도연이가 (x, y)에 있다면 이동할 수 있는 곳은 (x+1, y), (x, y+1), (x-1, y), (x, y-1)이다. 
  단, 캠퍼스의 밖으로 이동할 수는 없다.
  불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.
입력
- 첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수 N (1 <= N <= 600), M (1 <= M <= 600)이 주어진다.
  둘째 줄부터 N개의 줄에는 캠퍼스의 정보들이 주어진다. 
  O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. 
  I가 한 번만 주어짐이 보장된다.
출력
- 첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 
  단, 아무도 만나지 못한 경우 TT를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon21736_1 {
  static int n, m;
  static int count = 0;
  static char[][] campus;
  static boolean[][] visited;
  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    campus = new char[n][m];
    visited = new boolean[n][m];

    int pos_x = 0;      // 도연이 위치 x좌표
    int pos_y = 0;      // 도연이 위치 y좌표

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        campus[i][j] = s.charAt(j);

        if (campus[i][j] == 'I') {
          pos_x = i;
          pos_y = j;
        }
      }
    }

    dfs(pos_x, pos_y);

    System.out.println(count == 0 ? "TT" : count);
  }

  private static void dfs(int pos_x, int pos_y) {
    visited[pos_x][pos_y] = true;

    if (campus[pos_x][pos_y] == 'P') count++;

    for (int k = 0; k < 4; k++) {
      int x = pos_x + dx[k];
      int y = pos_y + dy[k];

      if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
        if (campus[x][y] != 'X') {
          dfs(x, y);
        }
      }
    }
  }
}
