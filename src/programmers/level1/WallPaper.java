package programmers.level1;
// 바탕화면 정리

public class WallPaper {
  public static void main(String[] args) {
    String[] wallpaper = {".#...", "..#..", "...#."};

    // 드래그 시작점
    int lux = Integer.MAX_VALUE;
    int luy = Integer.MAX_VALUE;

    // 드래그 끝점
    int rdx = 0;
    int rdy = 0;

    for (int i = 0; i < wallpaper.length; i++) {


      for (int j = 0; j < wallpaper[0].length(); j++) {
        if (wallpaper[i].charAt(j) == '#') {
          if (lux > i) lux = i;
          if (luy > j) luy = j;

          if (rdx < i) rdx = i;
          if (rdy < j) rdy = j;
        }
      }
    }
    System.out.println(lux + " " + luy + " " + rdx + " " + rdy);
  }
}
