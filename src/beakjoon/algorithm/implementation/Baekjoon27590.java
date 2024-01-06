package beakjoon.algorithm.implementation;
/*
문제
- You recently missed an eclipse and are waiting for the next one! 
  To see any eclipse from your home, the sun and the moon must be in alignment at specific positions. 
  You know how many years ago the sun was in the right position, 
  and how many years it takes for it to get back to that position. 
  You know the same for the moon. When will you see the next eclipse?
입력
- The input consists of two lines.
  The first line contains two integers, d_s and y_s (0 <= d_s < y_s <= 50), 
  where d_s is how many years ago the sun was in the right position, 
  and y_s is how many years it takes for the sun to be back in that position.
  The second line contains two integers, d_m and y_m (0 <= d_m < y_m <= 50), 
  where d_m is how many years ago the moon was in the right position, 
  and y_m is how many years it takes for the moon to be back in that position.
출력
- Output a single integer, the number of years until the next eclipse. 
  The data will be set in such a way that there is not an eclipse happening right now 
  and there will be an eclipse within the next 5,000 years.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon27590 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean[] sun = new boolean[5000];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int d = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int year = -d;
    while(year < 5000) {
      if (year >= 0) {
        sun[year] = true;
      }
      year += y;
    }

    // moon
    st = new StringTokenizer(br.readLine());
    d = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    year = 0;
    year -= d;

    while(year < 5000) {
      year += y;
      if (sun[year]) {
        System.out.println(year);
        break;
      }
    }
  }
}
