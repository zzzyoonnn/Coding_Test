package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12840 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int time = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());
    int second = Integer.parseInt(st.nextToken());

    time += (hour * 60 * 60) + (minute * 60) + second;

    int q = Integer.parseInt(br.readLine());
    int c = 0;
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());

      int type = Integer.parseInt(st.nextToken());

      if (type == 1) {
        c = Integer.parseInt(st.nextToken());

        time += c;
      } else if (type == 2) {
        c = Integer.parseInt(st.nextToken());

        time -= c;
      } else {
        System.out.println(time);
        if (time < 0) {
          time += 60 * 60 * 60;
          time++;
        }

        int s = time % 60;
        time /= 60;

        int m = time % 60;
        int h = time / 60;


        System.out.println(h + " " + m + " " + s);
      }
    }
  }
}
