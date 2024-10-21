package programmers.level1;

import java.util.Arrays;

public class 공원산책 {
  public static int[] solution(String[] park, String[] routes) {
    int height = park.length;
    int width = park[0].length();

    int pos_x = 0, pos_y = 0;
    char[][] arr = new char[height][width];
    for (int i = 0; i < height; i++) {
      arr[i] = park[i].toCharArray();

      if (park[i].contains("S")) {
        pos_x = park[i].indexOf("S");
        pos_y = i;
      }
    }

    for (String s : routes) {
      String dir = s.split(" ")[0];
      int move = Integer.parseInt(s.split(" ")[1]);

      int nx = pos_x;
      int ny = pos_y;

      for (int j = 1; j <= move; j++) {
        if (dir.equals("N")) ny--;
        else if (dir.equals("S")) ny++;
        else if (dir.equals("W")) nx--;
        else if (dir.equals("E")) nx++;

        if (nx >= 0 && ny >= 0 && nx < width && ny < height) {
          if (arr[ny][nx] == 'X') break;

          if (j == move) {
            pos_x = nx;
            pos_y = ny;
          }
        }
      }
    }

    int[] answer = {pos_y, pos_x};
    return answer;
  }

  public static void main(String[] args) {
//    String[] park = {"SOO","OOO","OOO"};
//    String[] routes = {"E 2","S 2","W 1"};

    String[] park = {"SOO","OXX","OOO"};
    String[] routes = {"E 2","S 2","W 1"};

//    String[] park = {"OSO","OOO","OXO","OOO"};
//    String[] routes = {"E 2","S 3","W 1"};

    System.out.println(Arrays.toString(solution(park, routes)));
  }
}
