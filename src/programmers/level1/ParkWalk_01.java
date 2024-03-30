package programmers.level1;
// 공원 산책

public class ParkWalk_01 {
  public static void main(String[] args) {
    String[] park = {"SOO", "OOO", "OOO"};
    String[] routes = {"E 2", "S 2", "W 1"};

    //    String[] park = {"SOO", "OXX", "OOO"};
    //    String[] routes = {"E 2", "S 2", "W 1"};

    //    String[] park = {"OSO", "OOO", "OXO", "OOO"};
    //    String[] routes = {"E 2","S 3","W 1"};

    char[][] arr = new char[park.length][park[0].length()];

    int pos_x = 0;
    int pos_y = 0;


    // arr 배열 생성 & 시작점 찾기
    for (int i = 0; i < park.length; i++) {
      arr[i] = park[i].toCharArray();

      if (park[i].contains("S")) {
        pos_x = park[i].indexOf('S');
        pos_y = i;
      }
    }

    // 로봇 강아지가 수행할 명령어
    for (String s : routes) {
      String direction = s.split(" ")[0];
      int l = Integer.parseInt(s.split(" ")[1]);

      int x = pos_x;
      int y = pos_y;

      for (int i = 0; i < l; i++) {
        if (direction.equals("E")) x++;
        else if (direction.equals("W")) x--;
        else if (direction.equals("S")) y++;
        else if (direction.equals("N")) y--;



        if (x >= 0 && y >= 0 && x < park[0].length() && y < park.length) {
          if (arr[y][x] == 'X') break;      // 공원 안이라도, 장애물을 만나면 수행 X

          // 이동을 다 했다면
          if (i == l - 1) {
            pos_x = x;
            pos_y = y;
          }
        }
      }
    }
    System.out.println(pos_y + " " + pos_x);
  }
}
