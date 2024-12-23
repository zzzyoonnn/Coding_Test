package beakjoon.algorithm.ShortestPath.FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11581 {
  static int N;
  static int INF = Integer.MAX_VALUE / 2;
  static int[][] routes;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());    // 교차로의 수

    initialization();

    StringTokenizer st;
    for (int route = 1; route < N; route++) {
      int num = Integer.parseInt(br.readLine());  // route번째 교차로와 연결된 교차로의 수

      st = new StringTokenizer(br.readLine());
      for (int connetion = 1; connetion <= num; connetion++) {
        int con = Integer.parseInt(st.nextToken());
        routes[route][con] = 1;
      }
    }

    floydWarshall(routes);

    if (findTwoWay()) System.out.println("CYCLE");
    else System.out.print("NO CYCLE");
  }

  private static boolean findTwoWay() {
    boolean check = false;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (routes[1][i] != INF) {    // 1에서 i로 가는 경로 존재하는가?
          if (routes[i][j] != INF && routes[j][i] != INF) {   // i와 j간 양방향 경로가 존재하는가?
            check = true;
            break;
          }
        }
      }
    }

    return check;
  }

  private static void floydWarshall(int[][] routes) {
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (routes[i][k] != INF && routes[k][j] != INF && routes[i][j] > routes[i][k] + routes[k][j]) {
            routes[i][j] = routes[i][k] + routes[k][j];
          }
        }
      }
    }
  }

  private static void initialization() {
    routes = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        routes[i][j] = INF;
      }
    }
  }
}
