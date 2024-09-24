package programmers.level1;

import java.util.Arrays;

public class 바탕화면정리 {
  public static int[] solution(String[] wallpaper) {
    // Start point
    int lux = wallpaper.length;
    int luy = wallpaper[0].length();

    // End point
    int rdx = -1;
    int rdy = -1;

    for (int i = 0; i < wallpaper.length; i++) {
      if (wallpaper[i].contains("#")) {

        int sx = i;
        int sy = wallpaper[i].indexOf("#");
        int ex = sx + 1;
        int ey = wallpaper[i].lastIndexOf("#") + 1;

        lux = Math.min(lux, sx);
        luy = Math.min(luy, sy);
        rdx = Math.max(rdx, ex);
        rdy = Math.max(rdy, ey);
      }
    }

    int[] answer = {lux, luy, rdx, rdy};
    return answer;
  }

  public static void main(String[] args) {
//    String[] wallpaper = {".#...", "..#..", "...#."};
//    String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//    String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
//    String[] wallpaper = {"..", "#."};
    String[] wallpaper = {".....", "....#"};

    System.out.println(Arrays.toString(solution(wallpaper)));
  }
}
