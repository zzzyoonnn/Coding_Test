package beakjoon.algorithm.string;
/*
문제
- 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
  각 테스트 케이스는 한 줄로 이루어져 있으며, 
  각 줄에 A와 B가 주어진다. A와 B는 콤마(,)로 구분되어 있다. (0 < A, B < 10)
출력
- 각 테스트 케이스마다 A+B를 출력한다.
ex 1)
입력		출력
- 5			- 2
  1,1		  5
  2,3		  7
  3,4		  17
  9,8		  7
  5,2
*/
import java.io.*;
import java.util.*;

public class Baekjoon10953 {
	public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 갯수
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(),",");
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	System.out.println(a + b);
        }
	}
}
