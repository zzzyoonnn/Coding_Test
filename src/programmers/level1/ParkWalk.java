package programmers.level1;
// 공원 산책

import java.util.Arrays;

public class ParkWalk {
  public static void main(String[] args) {
    String[] park = {"SOO", "OOO", "OOO"};
    String[] routes = {"E 2", "S 2", "W 1"};

    //    String[] park = {"SOO", "OXX", "OOO"};
    //    String[] routes = {"E 2", "S 2", "W 1"};

    //    String[] park = {"OSO", "OOO", "OXO", "OOO"};
    //    String[] routes = {"E 2","S 3","W 1"};

    char[][] arr = new char[park.length][park[0].length()];

    // 시작 위치
    int pos_x = 0;
    int pos_y = 0;

    for(int i = 0; i < park.length; i++){
      arr[i] = park[i].toCharArray();

      if(park[i].contains("S")){
        pos_y = i;
        pos_x = park[i].indexOf("S");
      }
    }

    for(String s : routes){
      String dir = s.split(" ")[0];
      int len = Integer.parseInt(s.split(" ")[1]);

      int x = pos_x;
      int y = pos_y;

      for(int i = 0; i < len; i++){
        if(dir.equals("E")) x++;
        if(dir.equals("W")) x--;
        if(dir.equals("S")) y++;
        if(dir.equals("N")) y--;

        if(x >=0 && y >=0 && y < arr.length && x < arr[0].length){
          if(arr[y][x] == 'X'){
            break;
          }
          // 범위내 & 장애물 x
          if(i == len-1){
            pos_x = x;
            pos_y = y;
          }
        }
      }
    }       

    int[] answer = {pos_y, pos_x};
    System.out.println(Arrays.toString(answer));
  }
}
