package programmers.level1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 공원산책 {
  static int height, width;
  static char[][] arr;
  public static int[] solution(String[] park, String[] routes) {
    height = park.length;
    width = park[0].length();

    int [] pos = {0, 0};
    arr = new char[height][width];
    for (int i = 0; i < height; i++) {
      arr[i] = park[i].toCharArray();

      if (park[i].contains("S")) {
        pos[0] = park[i].indexOf("S");
        pos[1] = i;
      }
    }

    for (String s : routes) {
      String dir = s.split(" ")[0];
      int move = Integer.parseInt(s.split(" ")[1]);

      int pos_x = pos[0];
      int pos_y = pos[1];

      for (int j = 1; j <= move; j++) {
        switch (dir) {
          case "N":
            pos_y--;
            break;
          case "S":
            pos_y++;
            break;
          case "W":
            pos_x--;
            break;
          case "E":
            pos_x++;
            break;
        }

        if (pos_x >= 0 && pos_y >= 0 && pos_x < width && pos_y < height) {
          if (arr[pos_y][pos_x] == 'X') break;

          if (j == move) {
            pos[0] = pos_x;
            pos[1] = pos_y;
          }
        }
      }
    }

    return pos;
  }

  public static void main(String[] args) {
//    String[] park = {"SOO","OOO","OOO"};
//    String[] routes = {"E 2","S 2","W 1"};

//    String[] park = {"SOO","OXX","OOO"};
//    String[] routes = {"E 2","S 2","W 1"};

    String[] park = {"OSO","OOO","OXO","OOO"};
    String[] routes = {"E 2","S 3","W 1"};

    System.out.println(Arrays.toString(solution(park, routes)));
  }
}
