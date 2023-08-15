package beakjoon.algorithm.implementation;
/*
문제
- 평면에 네 개의 직사각형이 놓여 있는데 그 밑변은 모두 가로축에 평행하다. 
  이 네 개의 직사각형들은 서로 떨어져 있을 수도 있고, 
  겹쳐 있을 수도 있고, 
  하나가 다른 하나를 포함할 수도 있으며, 
  변이나 꼭짓점이 겹칠 수도 있다.
  이 직사각형들이 차지하는 면적을 구하는 프로그램을 작성하시오.
입력
- 입력은 네 줄이며, 각 줄은 직사각형의 위치를 나타내는 네 개의 정수로 주어진다. 
  첫 번째와 두 번째의 정수는 사각형의 왼쪽 아래 꼭짓점의 x좌표, y좌표이고 
  세 번째와 네 번째의 정수는 사각형의 오른쪽 위 꼭짓점의 x좌표, y좌표이다. 
  모든 x좌표와 y좌표는 1이상이고 100이하인 정수이다.
출력
- 첫 줄에 네개의 직사각형이 차지하는 면적을 출력한다.
ex 1)
입력          출력
- 1 2 4 4     - 26
  2 3 5 7
  3 1 6 5
  7 3 8 6
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2669 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[][] map = new boolean[100][100];

    for (int i = 0; i < 4; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          map[y][x] = true;
        }
      }
    }

    int count = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (map[i][j] == true) {
          count++;
        }
      }
    }

    System.out.println(count);

  }
}