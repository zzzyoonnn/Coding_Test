package beakjoon.algorithm.implementation;
/*
문제
- 우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 
  배(0)와 등(1)이 나오는 숫자를 세어 
  도, 개, 걸, 윷, 모를 결정한다. 
  네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등 정보가 주어질 때 
  도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 
  걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개) 중 
  어떤 것인지를 결정하는 프로그램을 작성하라.
입력
- 첫째 줄부터 셋째 줄까지 
  각 줄에 각각 한 번 던진 윷짝들의 상태를 나타내는 
  네 개의 정수(0 또는 1)가 빈칸을 사이에 두고 주어진다.
출력
- 첫째 줄부터 셋째 줄까지 
  한 줄에 하나씩 결과를 도는 A, 개는 B, 걸은 C, 윷은 D, 모는 E로 출력한다.
ex 1)
입력		    출력
- 0 1 0 1       - B
  1 1 1 0         A
  0 0 1 1         B
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2490 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int [] arr = new int[4];

    for (int i = 1; i <= 3; i++) {
      int check = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        arr[i] = Integer.parseInt(st.nextToken());
        if (arr[i] == 1) check ++;
      }

      if (check == 3) System.out.println("A");
      else if (check == 2) System.out.println("B");
      else if (check == 1) System.out.println("C");
      else if (check == 0) System.out.println("D");
      else System.out.println("E");
    }

  }
}
